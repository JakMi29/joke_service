package com.jakmi.joke_service.api.rest;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.api.rest.request.EditJokeRequest;
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
    public ResponseEntity<String> createJoke(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody AddJokeRequest request
    ) {
        Joke joke = jokeService.createJoke(request, extractToken(token));
        if (joke != null) {
            return ResponseEntity.ok("Joke %s created successfully".formatted(joke.getName()));
        } else {
            return ResponseEntity.badRequest().body("Failed to create a joke");
        }
    }

    @GetMapping(value = "/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Joke>> joke(
            @PathVariable Integer pageNumber,
            @PathVariable Integer pageSize
    ) {
        return ResponseEntity.ok(jokeService.findAll(pageNumber, pageSize));
    }


    @GetMapping(value = "/byUser/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Joke>> getUserJoke(
            @RequestBody String userName,
            @PathVariable Integer pageNumber,
            @PathVariable Integer pageSize
    ) {
        return ResponseEntity.ok(jokeService.findByUserName(userName, pageNumber, pageSize));
    }

    @GetMapping(value = "/category/{name}/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Joke>> jokeByCategory(
            @PathVariable String name,
            @PathVariable Integer pageNumber,
            @PathVariable Integer pageSize
    ) {
        return ResponseEntity.ok(jokeService.findByCategory(name, pageNumber, pageSize));
    }

    @PatchMapping
    public ResponseEntity<String> editJoke(@RequestBody EditJokeRequest editJokeRequest) {
        jokeService.editJoke(editJokeRequest);
        return ResponseEntity.ok("Joke: %s was changed successful".formatted(editJokeRequest.getOldName()));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteJoke(@RequestBody String jokeName) {
        jokeService.deleteJoke(jokeName);
        return ResponseEntity.ok("Joke: %s was deleted successful".formatted(jokeName));
    }

    private String extractToken(String token) {
        return jwtService.extractUsername(token.split(" ")[1]);
    }
}
