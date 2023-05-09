package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepo extends CrudRepository<Item, Long> {
}
