package com.jakmi.joke_service.business.dao;

import com.jakmi.joke_service.doamin.ServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.ServiceUserEntity;

import java.util.Optional;

public interface ServiceUserDAO {
    Optional<ServiceUser> findByEmail(String email);

    void deleteByEmail(String email);

    Optional<ServiceUser> findByUserName(String username);

    void createUser(ServiceUser user);
}
