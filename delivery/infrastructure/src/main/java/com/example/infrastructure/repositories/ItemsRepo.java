package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepo extends CrudRepository<Item, Integer> {
}
