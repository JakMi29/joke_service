package com.jakmi.joke_service.api.rest;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.business.JokeService;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.infrastructure.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/joke")
public class JokeController {
    private final JwtService jwtService;
    private final JokeService jokeService;

    @PostMapping
    public ResponseEntity<String> create(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody AddJokeRequest request
    ) {
        Joke joke = jokeService.createJoke(request, extractToken(token));
        if (joke != null) {
            return ResponseEntity.ok("Joke [%s] created successfully".formatted(joke.getDescription()));
        } else {
            return ResponseEntity.badRequest().body("Failed to create a joke");
        }
    }

    @GetMapping(value="/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Joke>> joke(
            @PathVariable Integer pageNumber,
            @PathVariable Integer pageSize,
            @RequestHeader(name = "Authorization") String token
    ) {
        return ResponseEntity.ok(jokeService.findAll(pageNumber,pageSize));
    }

    @GetMapping(value="/category/{name}/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Joke>> jokeByCategory(
            @PathVariable String name,
            @PathVariable Integer pageNumber,
            @PathVariable Integer pageSize,
            @RequestHeader(name = "Authorization") String token
    ) {
        return ResponseEntity.ok(jokeService.findByCategory(name,pageNumber,pageSize));
    }

    private String extractToken(String token) {
        return jwtService.extractUsername(token.split(" ")[1]);
    }
}