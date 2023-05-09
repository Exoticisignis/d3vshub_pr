package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends CrudRepository<OrderItem, Long> {
}
