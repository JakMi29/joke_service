package com.jakmi.joke_service.infrastructure.database.repository;

import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeEntityMapper;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeServiceUserEntityMapper;
import com.jakmi.joke_service.infrastructure.database.repository.jpa.JokeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JokeRepository implements JokeDAO {

    private final JokeJpaRepository repository;
    private final JokeEntityMapper JokeEntityMapper;
    private final JokeServiceUserEntityMapper userEntityMapper;

    @Override
    public List<Joke> findAll() {
        return repository.findAll().stream().map(JokeEntityMapper::map).toList();
    }

    @Override
    public Joke createJoke(Joke joke) {
        System.out.println(joke);
        JokeEntity map = JokeEntityMapper.map(joke);
        JokeEntity entity = repository.save(map);
        return JokeEntityMapper.map(entity);
    }

    @Override
    public Page<JokeEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<JokeEntity> findByCategory(Category category, Pageable pageable) {
        return repository.findByCategory(category, pageable);
    }

    @Override
    public void deleteJoke(String name) {
        this.repository.deleteByName(name);
    }

    @Override
    public Page<JokeEntity> findByUser(JokeServiceUser jokeServiceUser, Pageable pageable) {
        JokeServiceUserEntity user=userEntityMapper.map(jokeServiceUser);
        return repository.findByOwner(user,pageable);
    }


}
