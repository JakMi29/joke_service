package com.jakmi.joke_service.business.dao;

import com.jakmi.joke_service.api.auth.RegisterRequest;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeServiceUserEntityMapper;

import java.util.Optional;

public interface JokeServiceUserDAO {
    Optional<JokeServiceUser> findByEmail(String email);
    void deleteByEmail(String email);

    Optional<JokeServiceUser> findByUserName(String username);

    void createUser(JokeServiceUserEntity user);
}
