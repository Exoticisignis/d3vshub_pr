package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Order, Integer> {
}
