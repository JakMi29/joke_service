package com.jakmi.joke_service.api.rest.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class EditJokeRequest {
    @NotBlank
    private String oldName;
    @NotBlank
    private String newName;
    @NotBlank
    private String contents;
    @NotBlank
    private String category;
}
