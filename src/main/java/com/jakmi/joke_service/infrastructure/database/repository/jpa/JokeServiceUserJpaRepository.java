package com.jakmi.joke_service.infrastructure.database.repository.jpa;

import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JokeServiceUserJpaRepository extends JpaRepository<JokeServiceUserEntity,Integer> {
    Optional<JokeServiceUserEntity> findByEmail(String email);
    void deleteByEmail(String email);

    Optional<JokeServiceUserEntity> findByUsername(String username);
}
