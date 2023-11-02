package com.jakmi.joke_service.business.dao;

import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JokeDAO {
    List<JokeEntity> findAll();

    Joke createJoke(JokeEntity joke);
    Page<JokeEntity> findAll(Pageable pageable);

    Page<JokeEntity> findByCategory(Category category, Pageable pageable);

    void deleteJoke(String jokeName);

    Page<JokeEntity> findByUser(JokeServiceUser jokeServiceUser, Pageable pageable);
}
