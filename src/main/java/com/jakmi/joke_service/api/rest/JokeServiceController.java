package com.jakmi.joke_service.api.rest;

import com.jakmi.joke_service.business.JokeService;
import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.infrastructure.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/joke_service/user")
public class JokeServiceController {
private final JwtService jwtService;
private final JokeService jokeService;

@GetMapping(name="/details")
public ResponseEntity<String> userDetails(@RequestHeader(name = "Authorization") String token) {
    return ResponseEntity.ok(jwtService.extractUsername(extractToken(token)));
}
    @GetMapping(name="/user_jokes")
    public ResponseEntity<String> userJokes(@RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(jwtService.extractUsername(extractToken(token)));
    }
    @GetMapping(name="/jokes")
    public ResponseEntity<String> jokes(@RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(jwtService.extractUsername(extractToken(token)));
    }

private String extractToken(String token){
    return token.split(" ")[1];
}
}
