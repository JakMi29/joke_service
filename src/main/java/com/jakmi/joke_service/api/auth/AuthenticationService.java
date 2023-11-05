package com.jakmi.joke_service.api.auth;

import com.jakmi.joke_service.business.dao.ServiceUserDAO;
import com.jakmi.joke_service.doamin.ServiceUser;
import com.jakmi.joke_service.doamin.exception.UserAlreadyExist;
import com.jakmi.joke_service.infrastructure.database.entity.ServiceUserEntity;
import com.jakmi.joke_service.infrastructure.security.JwtService;
import com.jakmi.joke_service.infrastructure.security.Role;
import com.jakmi.joke_service.infrastructure.security.User;
import com.jakmi.joke_service.infrastructure.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ServiceUserDAO serviceUserDAO;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {

        Optional<User> existingUser = repository.findByEmail(request.getEmail());
        if (existingUser.isPresent())
            throw new UserAlreadyExist("Email: %s is already taken".formatted(request.getEmail()));

        Optional<ServiceUser> existingJokeServiceUser = serviceUserDAO.findByUserName(request.getUsername());
        if (existingJokeServiceUser.isPresent())
            throw new UserAlreadyExist("Username: %s is already taken".formatted(request.getUsername()));

        var user = buildUser(request);
        repository.save(user);

        var serviceUser = buildServiceUser(request);
        serviceUserDAO.createUser(serviceUser);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Transactional
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private User buildUser(RegisterRequest request) {
        return User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
    }

    private ServiceUser buildServiceUser(RegisterRequest request) {
        return ServiceUser.builder()
                .email(request.getEmail())
                .userName(request.getUsername())
                .jokes(new ArrayList<>())
                .build();
    }
}
