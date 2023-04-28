package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Tracking;
import org.springframework.data.repository.CrudRepository;

public interface TrackingRepo extends CrudRepository<Tracking, Integer> {
}
