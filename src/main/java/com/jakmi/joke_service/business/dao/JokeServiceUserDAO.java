package com.jakmi.joke_service.business.dao;

import com.jakmi.joke_service.api.auth.RegisterRequest;
import com.jakmi.joke_service.doamin.JokeServiceUser;

public interface JokeServiceUserDAO {
    JokeServiceUser findByEmail(String email);
    void deleteByEmail(String email);

    JokeServiceUser findByUserName(String username);

    void createUser(RegisterRequest request);
}
