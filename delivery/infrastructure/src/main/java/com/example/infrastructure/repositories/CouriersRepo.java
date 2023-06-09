package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CouriersRepo extends JpaRepository<Courier, Long> {

    @Query("select c from Courier c order by c.courierId asc limit :n")
    public List<Courier> getNCouriers(@Param("n") int n);

    @Query("select case when count(c)> 0 then true else false end from Courier c where c.login = :login")
    boolean existsByLogin(@Param("login") String login);

    Optional<Courier> findById(Long id);
}

