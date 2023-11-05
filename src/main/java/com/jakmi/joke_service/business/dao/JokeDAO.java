package com.jakmi.joke_service.business.dao;

import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.ServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JokeDAO {
    List<JokeEntity> findAll();

    Joke createJoke(Joke joke);

    List<Joke> findAll(Pageable pageable);

    List<Joke> findByCategory(Category category, Pageable pageable);

    void deleteJoke(String jokeName);

    List<Joke> findByUser(ServiceUser serviceUser, Pageable pageable);

    Joke findByName(String oldName);
}
