package com.jakmi.joke_service.api.rest;

import com.jakmi.joke_service.api.rest.request.UpdateUserRequest;
import com.jakmi.joke_service.business.ServiceUserService;
import com.jakmi.joke_service.infrastructure.security.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class ServiceUserController {
    private final JwtService jwtService;
    private final ServiceUserService jokeServiceUser;

    @DeleteMapping
    public void deleteUser(@RequestHeader(name = "Authorization") String token) {
        String email = jwtService.extractUsername(token.split(" ")[1]);
        jokeServiceUser.deleteUser(email);
    }

    @PatchMapping
    public void updateUser(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody @Valid UpdateUserRequest updateUserRequest
    ) {
        updateUserRequest.setOldEmail(extractToken(token));
        jokeServiceUser.updateUserData(updateUserRequest);
    }

    private String extractToken(String token) {
        return jwtService.extractUsername(token.split(" ")[1]);
    }
}
