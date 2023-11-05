package com.jakmi.joke_service.business;

import com.jakmi.joke_service.api.rest.request.UpdateUserRequest;
import com.jakmi.joke_service.business.dao.ServiceUserDAO;
import com.jakmi.joke_service.doamin.ServiceUser;
import com.jakmi.joke_service.doamin.exception.NotFoundException;
import com.jakmi.joke_service.doamin.exception.UserAlreadyExist;
import com.jakmi.joke_service.infrastructure.security.User;
import com.jakmi.joke_service.infrastructure.security.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceUserService {
    private final ServiceUserDAO serviceUserDAO;
    private final UserRepository userRepository;

    @Transactional
    public ServiceUser findByEmail(String email) {
        return serviceUserDAO.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with email: %s does not exist".formatted(email)));
    }

    @Transactional
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
        serviceUserDAO.deleteByEmail(email);
    }

    @Transactional
    public ServiceUser findByUsername(String username) {
        return serviceUserDAO.findByUserName(username)
                .orElseThrow(() -> new NotFoundException("User with username: %s does not exist".formatted(username)));
    }

    @Transactional
    public void updateUserData(UpdateUserRequest updateUserRequest) {
        System.out.println(updateUserRequest.getOldEmail());
        ServiceUser serviceUser = serviceUserDAO.findByEmail(updateUserRequest.getOldEmail())
                .orElseThrow(() -> new NotFoundException(
                        "User with email: %s does not exist".formatted(updateUserRequest.getOldEmail())));

        User user = userRepository.findByEmail(updateUserRequest.getOldEmail())
                .orElseThrow(() -> new NotFoundException(
                        "User with email: %s does not exist".formatted(updateUserRequest.getOldEmail())));

        Optional<User> userOptional = userRepository.findByEmail(updateUserRequest.getNewEmail());
        checkNewEmail(userOptional, updateUserRequest.getNewEmail());
        serviceUser = getUpdateServiceUser(serviceUser, updateUserRequest);
        getUpdateUser(user, updateUserRequest);
        serviceUserDAO.createUser(serviceUser);
        userRepository.save(user);
    }

    private ServiceUser getUpdateServiceUser(ServiceUser serviceUser, UpdateUserRequest updateUserRequest) {
        return serviceUser
                .withEmail(updateUserRequest.getNewEmail())
                .withUserName(updateUserRequest.getUsername());
    }

    private void getUpdateUser(User user, UpdateUserRequest updateUserRequest) {
        user.setEmail(updateUserRequest.getNewEmail());
        user.setFirstname(updateUserRequest.getFirstname());
        user.setLastname(updateUserRequest.getLastname());
    }

    private void checkNewEmail(Optional<User> user, String newEmail) {
        if (user.isPresent())
            throw new UserAlreadyExist("User with email: %s already exist".formatted(newEmail));
    }
}
