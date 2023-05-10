package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Courier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CouriersRepo extends CrudRepository<Courier, Long> {
    long count();
}
