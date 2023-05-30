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
@Table(name = "couriers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier extends BaseEntity{
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

    @Override
    public String toString(){
        return this.getName() + " " + this.getSurname();
    }

    public Courier(String value){
        this.name = value;
        this.surname = value;
        this.phone = value;
        this.salt = value;
        this.login = value;
        this.hashedPassword = value;
    }
}
