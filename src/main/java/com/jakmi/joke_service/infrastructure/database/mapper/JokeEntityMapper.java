package com.jakmi.joke_service.infrastructure.database.mapper;

import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import org.springframework.stereotype.Component;

@Component
public class JokeEntityMapper {
    public Joke map(JokeEntity entity) {
        return Joke.builder()
                .id(entity.getId())
                .contents(entity.getContents())
                .name(entity.getName())
                .category(entity.getCategory())
                .owner(
                        JokeServiceUser.builder()
                                .id(entity.getId())
                                .email(entity.getOwner().getEmail())
                                .userName(entity.getOwner().getUsername())
                                .build()
                )
                .build();
    }

    public JokeEntity map(Joke joke) {

        return JokeEntity.builder()
                .contents(joke.getContents())
                .name(joke.getName())
                .category(joke.getCategory())
                .owner(
                        JokeServiceUserEntity.builder()
                                .id(joke.getOwner().getId())
                                .email(joke.getOwner().getEmail())
                                .username(joke.getOwner().getUserName())
                                .build()
                )
                .build();
    }
}
