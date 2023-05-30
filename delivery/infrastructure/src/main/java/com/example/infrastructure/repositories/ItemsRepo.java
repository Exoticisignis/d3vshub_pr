package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepo extends JpaRepository<Item, Long> {
}
