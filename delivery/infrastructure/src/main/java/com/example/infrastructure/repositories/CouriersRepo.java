package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Courier;
import org.springframework.data.repository.CrudRepository;

public interface CouriersRepo extends CrudRepository<Courier, Integer> {
}
