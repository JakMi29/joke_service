package com.jakmi.joke_service.infrastructure.database.repository;

import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.ServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.entity.ServiceUserEntity;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeEntityMapper;
import com.jakmi.joke_service.infrastructure.database.mapper.ServiceUserEntityMapper;
import com.jakmi.joke_service.infrastructure.database.repository.jpa.JokeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class JokeRepository implements JokeDAO {

    private final JokeJpaRepository repository;
    private final JokeEntityMapper mapper;
    private final ServiceUserEntityMapper serviceUserEntityMapper;

    @Override
    public List<JokeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Joke createJoke(Joke joke) {
        return mapper.map(repository.save(mapper.map(joke)));
    }

    @Override
    public List<Joke> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Joke> findByCategory(Category category, Pageable pageable) {
        return repository.findByCategory(category, pageable).stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteJoke(String name) {
        this.repository.deleteByName(name);
    }

    @Override
    public List<Joke> findByUser(ServiceUser serviceUser, Pageable pageable) {
        ServiceUserEntity user = serviceUserEntityMapper.map(serviceUser);
        return repository.findByOwner(user, pageable).stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public Joke findByName(String oldName) {
        return mapper.map(repository.findByName(oldName));
    }


}
