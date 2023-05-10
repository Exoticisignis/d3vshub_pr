package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepo extends CrudRepository<Customer, Long> {
    long count();
}
