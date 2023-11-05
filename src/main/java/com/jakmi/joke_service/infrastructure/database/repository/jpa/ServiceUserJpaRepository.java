package com.jakmi.joke_service.infrastructure.database.repository.jpa;

import com.jakmi.joke_service.infrastructure.database.entity.ServiceUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceUserJpaRepository extends JpaRepository<ServiceUserEntity, Integer> {
    Optional<ServiceUserEntity> findByEmail(String email);

    void deleteByEmail(String email);

    Optional<ServiceUserEntity> findByUsername(String username);
}
