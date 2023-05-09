package com.example.infrastructure.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

@Entity
@Table(name = "Couriers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private Long courierId;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String phone;

    @NonNull
    private String salt;

    @NonNull
    @Column(name = "hashed_password")
    private String hashedPassword;

    @NonNull
    private String login;
}