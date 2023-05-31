package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveriesRepo extends JpaRepository<Delivery, Long> {
    @Query("select d from Delivery d order by d.id asc limit :n")
    public List<Delivery> getNDeliveries(@Param("n") int n);
}
