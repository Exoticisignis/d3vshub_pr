package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Delivery;
import com.example.infrastructure.entities.Tracking;
import com.example.infrastructure.models.TrackingDTO;
import com.example.infrastructure.repositories.DeliveriesRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TrackingDTOMapper {


    public static TrackingDTO trackingToDTO(Tracking t){
        TrackingDTO dto = new TrackingDTO();
        dto.setId(t.getId());
        dto.setDelivery(t.getDelivery().getId());
        dto.setStatus(t.getStatus());
        dto.setLocation(t.getLocation());
        dto.setUpdateTime(t.getUpdateTime().toString());
        return dto;
    }

    public static Tracking DTOtoEntity(TrackingDTO dto){
        Tracking t = new Tracking();
        t.setStatus(dto.getStatus());
        t.setLocation(dto.getLocation());
        t.setUpdateTime(Timestamp.valueOf(dto.getUpdateTime()));
        return t;
    }
}
