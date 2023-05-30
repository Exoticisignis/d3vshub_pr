package com.example.infrastructure.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(of = "uuid")
public class BaseEntity {
    public String uuid = UUID.randomUUID().toString();
}
