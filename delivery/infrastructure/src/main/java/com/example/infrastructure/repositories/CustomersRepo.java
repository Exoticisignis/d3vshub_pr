package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepo extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c order by c.customerId asc limit :n")
    public List<Customer> getNCustomers(@Param("n")int n);

    @Query("select case when count(c)> 0 then true else false end from Customer c where c.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("select count(*) from Customer")
    int getNumberOfRows();

    Optional<Customer> findById(Long id);
}
