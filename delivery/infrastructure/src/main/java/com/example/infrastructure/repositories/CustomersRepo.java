package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Long id);
}
