package com.jakmi.joke_service.doamin;

import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

import java.util.List;
import java.util.Set;
@Value
@With
@Builder
@EqualsAndHashCode
public class JokeServiceUser {
    Integer id;
    String userName;
    String email;
    List<Joke> jokes;
}
