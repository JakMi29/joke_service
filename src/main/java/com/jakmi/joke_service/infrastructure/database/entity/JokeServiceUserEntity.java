package com.jakmi.joke_service.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="joke_service_user")
public class JokeServiceUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner",cascade = CascadeType.REMOVE)
    private Set<JokeEntity> jokes;
}
