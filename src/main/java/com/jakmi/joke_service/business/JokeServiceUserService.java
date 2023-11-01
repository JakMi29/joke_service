package com.jakmi.joke_service.business;

import com.jakmi.joke_service.api.auth.RegisterRequest;
import com.jakmi.joke_service.business.dao.JokeServiceUserDAO;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.security.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class JokeServiceUserService {
    private final JokeServiceUserDAO jokeServiceUserDAO;
    private final UserRepository userRepository;

    @Transactional
    public JokeServiceUser findByEmail(String email) {
        return jokeServiceUserDAO.findByEmail(email);
    }

    @Transactional
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
        jokeServiceUserDAO.deleteByEmail(email);
    }

    @Transactional
    public JokeServiceUser findByUsername(String username) {
        return jokeServiceUserDAO.findByUserName(username);
    }
    @Transactional
    public void createUser(RegisterRequest request){
        jokeServiceUserDAO.createUser(request);
    }
}
