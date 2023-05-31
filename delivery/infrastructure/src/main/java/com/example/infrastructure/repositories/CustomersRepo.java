package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Long id);

    @Query("SELECT * FROM customers LIMIT :n")
    public List<Customer> getNCustomers(int n);
}
