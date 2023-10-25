package com.jakmi.joke_service.business.dao;

import com.jakmi.joke_service.doamin.JokeServiceUser;

public interface JokeServiceUserDAO {
    JokeServiceUser findByEmail(String email);
}
