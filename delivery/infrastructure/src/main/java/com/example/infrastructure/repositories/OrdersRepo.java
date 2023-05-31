package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Order, Long> {
    @Query("SELECT * FROM orders LIMIT :n")
    public List<Order> getNOrders(int n);

    @Query("SELECT * FROM orders WHERE customer_id = :id")
    public List<Order> getOrdersForCustomerId(Long id);
}
