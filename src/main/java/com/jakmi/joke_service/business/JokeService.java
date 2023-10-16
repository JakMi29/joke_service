package com.jakmi.joke_service.business;

import com.jakmi.joke_service.business.dao.JokeDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JokeService {
    private final JokeDAO jokeDAO;


}
