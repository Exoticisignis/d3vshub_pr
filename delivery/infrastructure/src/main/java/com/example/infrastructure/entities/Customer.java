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
@Table(name = "Customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String address;

    @NonNull
    private String phone;

    @NonNull
    private String email;

    @NonNull
    private String salt;

    @NonNull
    @Column(name = "hashed_password")
    private String hashedPassword;
    @Override
    public String toString(){
        return this.name + " " + this.surname;
    }
    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
}
