package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepo extends JpaRepository<Tracking, Long> {
}
