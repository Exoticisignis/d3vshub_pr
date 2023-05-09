package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Tracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepo extends CrudRepository<Tracking, Long> {
}
