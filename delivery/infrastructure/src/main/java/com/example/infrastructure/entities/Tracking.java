package com.example.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "Tracking")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Instant updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id")
    private Delivery delivery;
}
