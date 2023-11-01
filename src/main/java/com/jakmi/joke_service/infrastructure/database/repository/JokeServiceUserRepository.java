package com.jakmi.joke_service.infrastructure.database.repository;

import com.jakmi.joke_service.api.auth.RegisterRequest;
import com.jakmi.joke_service.business.dao.JokeServiceUserDAO;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import com.jakmi.joke_service.infrastructure.database.repository.jpa.JokeServiceUserJpaRepository;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeServiceUserEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
@AllArgsConstructor
public class JokeServiceUserRepository implements JokeServiceUserDAO {

    private final JokeServiceUserJpaRepository repository;
    private final JokeServiceUserEntityMapper mapper;
    @Override
    public JokeServiceUser findByEmail(String email) {
        JokeServiceUserEntity user = repository.findByEmail(email);
        return mapper.map(user);
    }

    @Override
    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public JokeServiceUser findByUserName(String username) {
        JokeServiceUserEntity user = repository.findByUsername(username);
        return mapper.map(user);
    }

    @Override
    public void createUser(RegisterRequest request) {
        JokeServiceUserEntity entity= JokeServiceUserEntity.builder()
                .email(request.getEmail())
                .jokes(new HashSet<>())
                .username(request.getUsername())
                .build();
        repository.save(entity);
    }
}
