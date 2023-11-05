package com.jakmi.joke_service.infrastructure.database.repository.jpa;

import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.entity.ServiceUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeJpaRepository extends JpaRepository<JokeEntity, Integer> {
    Page<JokeEntity> findByCategory(Category category, Pageable pageable);

    void deleteByName(String name);

    Page<JokeEntity> findByOwner(ServiceUserEntity jokeServiceUser, Pageable pageable);

    JokeEntity findByName(String oldName);
}
