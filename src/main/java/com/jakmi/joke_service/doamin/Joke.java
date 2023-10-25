package com.jakmi.joke_service.doamin;

import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder
@EqualsAndHashCode
public class Joke {

    Integer id;
    String description;
    String contents;
    Category category;
    JokeServiceUser owner;
}
