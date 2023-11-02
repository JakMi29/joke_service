package com.jakmi.joke_service.infrastructure.database.repository;

import com.jakmi.joke_service.business.dao.JokeServiceUserDAO;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeServiceUserEntityMapper;
import com.jakmi.joke_service.infrastructure.database.repository.jpa.JokeServiceUserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JokeServiceUserRepository implements JokeServiceUserDAO {

    private final JokeServiceUserJpaRepository repository;
    private final JokeServiceUserEntityMapper jokeServiceUserEntityMapper;

    @Override
    public Optional<JokeServiceUser> findByEmail(String email) {
        return repository.findByEmail(email).map(jokeServiceUserEntityMapper::map);
    }

    @Override
    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public Optional<JokeServiceUser> findByUserName(String username) {
        return repository.findByUsername(username).map(jokeServiceUserEntityMapper::map);
    }

    @Override
    public void createUser(JokeServiceUserEntity user) {
        repository.save(user);
    }


}
