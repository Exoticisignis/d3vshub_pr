package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends CrudRepository<Order, Long> {
}
