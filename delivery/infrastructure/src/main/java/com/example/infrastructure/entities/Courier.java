package com.example.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long courier_id;
    @NonNull
    private String name;
    @NonNull
    private String login;
    @NonNull
    private String phone;
    @NonNull
    private String hashed_password;
    @NonNull
    private String salt;
}
