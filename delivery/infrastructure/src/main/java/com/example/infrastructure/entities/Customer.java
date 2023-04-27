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
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    private String password;
    @NonNull
    private String salt;
}
