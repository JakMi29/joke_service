package com.jakmi.joke_service.api.rest;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.business.JokeService;
import com.jakmi.joke_service.business.ServiceUserService;
import com.jakmi.joke_service.doamin.Joke;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final JokeService jokeService;
    private final ServiceUserService serviceUserService;
    @DeleteMapping("/joke")
    public ResponseEntity<String> deleteJoke(@RequestBody String jokeName) {
        jokeService.deleteJoke(jokeName);
        return ResponseEntity.ok("Joke: %s was deleted successful".formatted(jokeName));
    }
    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestBody String userEmail) {
        jokeService.deleteJoke(userEmail);
        return ResponseEntity.ok("User with email: %s was deleted successful".formatted(userEmail));
    }
}
