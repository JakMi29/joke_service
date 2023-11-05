package com.jakmi.joke_service.doamin;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@With
@Builder
@EqualsAndHashCode
public class ServiceUser {
    Integer id;
    String userName;
    String email;
    List<Joke> jokes;
}
