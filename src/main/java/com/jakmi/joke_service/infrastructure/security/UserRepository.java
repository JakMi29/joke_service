package com.jakmi.joke_service.infrastructure.security;

import com.jakmi.joke_service.infrastructure.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

}
