package com.jakmi.joke_service.infrastructure.database.mapper;

import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.ServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.entity.ServiceUserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ServiceUserEntityMapper {
    public ServiceUser map(ServiceUserEntity entity) {
        return ServiceUser.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .userName(entity.getUsername())
                .jokes(
                        entity.getJokes().stream()
                                .map(this::mapJoke).
                                collect(Collectors.toList())
                )
                .build();
    }

    public ServiceUserEntity map(ServiceUser user) {

        return ServiceUserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUserName())
                .jokes(
                        user.getJokes().stream()
                                .map(this::mapJoke)
                                .collect(Collectors.toSet())
                )
                .build();
    }

    private Joke mapJoke(JokeEntity entity) {
        return Joke.builder()
                .id(entity.getId())
                .contents(entity.getContents())
                .name(entity.getName())
                .build();
    }

    private JokeEntity mapJoke(Joke joke) {
        return JokeEntity.builder()
                .id(joke.getId())
                .contents(joke.getContents())
                .name(joke.getName())
                .build();
    }
}
