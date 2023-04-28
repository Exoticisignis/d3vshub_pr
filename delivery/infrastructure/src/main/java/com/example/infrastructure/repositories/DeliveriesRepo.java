package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Delivery;
import org.springframework.data.repository.CrudRepository;

public interface DeliveriesRepo extends CrudRepository<Delivery, Integer> {
}
