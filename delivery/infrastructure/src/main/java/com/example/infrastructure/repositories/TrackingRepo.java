package com.example.infrastructure.repositories;

import com.example.infrastructure.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepo extends JpaRepository<Tracking, Long> {
    @Query("select t from Tracking t order by t.id asc limit :n")
    public List<Tracking> getNTracking(@Param("n") int n);

    @Query("select t from Tracking t join t.delivery d where d.id = :id")
    public Tracking getTrackingForDeliveryId(@Param("id") Long id);
}
