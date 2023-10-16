package com.jakmi.joke_service.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="joke")
public class JokeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="description")
    private String description;
    @Column(name="contents")
    private String contents;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="joke_service_user_id")
    private JokeServiceUserEntity owner;
}
