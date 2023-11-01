package com.jakmi.joke_service.infrastructure.database.mapper;

import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class JokeServiceUserEntityMapper {
    public JokeServiceUser map(JokeServiceUserEntity entity){
        return JokeServiceUser.builder()
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
    public JokeServiceUserEntity map(JokeServiceUser user){

        return JokeServiceUserEntity.builder()
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

    private Joke mapJoke(JokeEntity entity){
        return Joke.builder()
                .id(entity.getId())
                .contents(entity.getContents())
                .name(entity.getName())
                .build();
    }
    private JokeEntity mapJoke(Joke joke){
        return JokeEntity.builder()
                .id(joke.getId())
                .contents(joke.getContents())
                .name(joke.getName())
                .build();
    }
}
