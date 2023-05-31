package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveriesRepo extends JpaRepository<Delivery, Long> {
    @Query("SELECT * FROM deliveries LIMIT :n")
    public List<Delivery> getNDeliveries(int n);
}
