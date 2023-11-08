package com.jakmi.joke_service.api.rest;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.doamin.Joke;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    @GetMapping
    public ResponseEntity<String> createJoke(@RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok("Hello Admin");
    }
}
