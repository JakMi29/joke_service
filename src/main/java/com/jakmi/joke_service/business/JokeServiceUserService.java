package com.jakmi.joke_service.business;

import com.jakmi.joke_service.business.dao.JokeServiceUserDAO;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JokeServiceUserService {
    private final JokeServiceUserDAO jokeServiceUserDAO;
    public JokeServiceUser findByEmail(String email){
        return jokeServiceUserDAO.findByEmail(email);
    }
}
