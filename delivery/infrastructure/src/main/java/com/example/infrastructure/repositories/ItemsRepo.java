package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepo extends JpaRepository<Item, Long> {
    @Query("select i from Item i where i.itemName = :name")
    Item findByName(@Param("name") String name);

    @Query("select i from Item i order by i.itemId asc limit :n")
    public List<Item> getNItems(@Param("n") int n);

}
