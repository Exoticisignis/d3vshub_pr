package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveriesRepo extends JpaRepository<Delivery, Long> {
}
