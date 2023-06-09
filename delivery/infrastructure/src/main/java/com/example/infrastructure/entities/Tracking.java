package com.example.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "tracking")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tracking extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Column(name = "update_date")
    private Timestamp updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id")
    private Delivery delivery;
}
