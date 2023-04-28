package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepo extends CrudRepository<OrderItem, Integer> {
}
