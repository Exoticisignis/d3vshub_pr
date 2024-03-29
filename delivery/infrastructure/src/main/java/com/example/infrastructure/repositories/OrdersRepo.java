package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepo extends JpaRepository<Order, Long> {
    @Query("select o from Order o order by o.orderId asc limit :n")
    public List<Order> getNOrders(@Param("n") int n);

    @Query("select o from Order o join o.customer c where c.customerId = :id")
    public List<Order> getOrdersForCustomerId(@Param("id") Long id);

    @Query("select count(*) from Order")
    int getNumberOfRows();

    Optional<Order> findById(Long id);

    @Query("select o from Order o where orderDate between :fromDate and :toDate")
    public List<Order> getOrdersInDates(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
