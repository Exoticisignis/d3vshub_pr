package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Courier;
import com.example.infrastructure.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepo extends JpaRepository<Tracking, Long> {
    @Query("SELECT * FROM tracking LIMIT :n")
    public List<Tracking> getNTracking(int n);
}
