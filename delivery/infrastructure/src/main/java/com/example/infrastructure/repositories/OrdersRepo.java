package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Order, Long> {
}
