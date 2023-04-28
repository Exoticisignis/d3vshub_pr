package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<Customer, Integer> {
}
