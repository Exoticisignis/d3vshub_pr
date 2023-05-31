package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepo extends JpaRepository<Item, Long> {
    //@Query("select i from items i where i.name = :name")
    Item findByName(String name);

    @Query("SELECT * FROM items LIMIT :n")
    public List<Item> getNItems(int n);
}
