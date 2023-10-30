package com.jakmi.joke_service.api.rest;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.business.JokeService;
import com.jakmi.joke_service.business.JokeServiceUserService;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class JokeServiceUserController {
    private final JwtService jwtService;
    private final JokeService jokeService;
    private final JokeServiceUserService jokeServiceUser;

    @DeleteMapping
    public void deleteUser(@RequestBody String userEmail){
    jokeServiceUser.deleteUser(userEmail);
    }
    private String extractToken(String token) {
        return jwtService.extractUsername(token.split(" ")[1]);
    }
}
