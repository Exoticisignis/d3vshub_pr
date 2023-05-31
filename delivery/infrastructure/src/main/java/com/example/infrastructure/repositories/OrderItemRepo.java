package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    @Query("select oI from OrderItem oI join oI.order o where o.orderId = :id")
    public List<OrderItem> getItemsForOrderId(@Param("id") Long id);

    @Query("select oI from OrderItem oI join oI.item i where i.itemId = :id")
    public List<OrderItem> getOrdersForItemId(@Param("id") Long id);
}
