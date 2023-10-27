package com.jakmi.joke_service.api.rest.request;

import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddJokeRequest {
    private String description;
    private String contents;
    private String category;
}
