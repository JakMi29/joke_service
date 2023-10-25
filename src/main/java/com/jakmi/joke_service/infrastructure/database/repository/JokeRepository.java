package com.jakmi.joke_service.infrastructure.database.repository;

import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.repository.jpa.JokeJpaRepository;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public class JokeRepository implements JokeDAO {

    private final JokeJpaRepository repository;
    private final JokeEntityMapper entityMapper;
    @Override
    public List<Joke> findAll() {
        return repository.findAll().stream().map(entityMapper::map).toList();
    }

    @Override
    public Joke createJoke(Joke joke) {
        System.out.println(joke);
        JokeEntity map = entityMapper.map(joke);
        System.out.println(map);
        JokeEntity entity= repository.save(map);
        return entityMapper.map(entity);
    }

    @Override
    public Page<JokeEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<JokeEntity> findByCategory(Category category, Pageable pageable) {
        return repository.findByCategory(category, pageable);
    }
}
