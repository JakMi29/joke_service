package com.jakmi.joke_service.doamin;

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
    String name;
    String contents;
    Category category;
    ServiceUser owner;
}
