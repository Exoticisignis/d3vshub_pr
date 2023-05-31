package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CouriersRepo extends JpaRepository<Courier, Long> {
    @Query("select c from Courier c order by c.courierId asc limit :n")
    public List<Courier> getNCouriers(@Param("n") int n);
}
