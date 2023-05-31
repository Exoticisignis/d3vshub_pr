package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CouriersRepo extends JpaRepository<Courier, Long> {
    @Query("SELECT * FROM couriers LIMIT :n")
    public List<Courier> getNCouriers(int n);
}
