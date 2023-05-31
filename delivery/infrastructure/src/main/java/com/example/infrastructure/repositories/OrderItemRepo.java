package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    @Query("SELECT * FROM order_items WHERE order_id = :id")
    public List<OrderItem> getItemsForOrderId(Long id);

    @Query("SELECT * FROM order_items WHERE item_id = :id")
    public List<OrderItem> getOrdersForItemId(Long id);
}
