package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Tracking;
import com.example.infrastructure.models.TrackingDTO;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TrackingDTOMapper {

    public static TrackingDTO trackingToDTO(Tracking t){
        TrackingDTO dto = new TrackingDTO();
        dto.setId(t.getId());
        dto.setDelivery(t.getDelivery().getId());
        dto.setStatus(t.getStatus());
        dto.setLocation(t.getLocation());
        dto.setUpdateTime(OffsetDateTime.ofInstant(t.getUpdateTime(), ZoneOffset.UTC));
        return dto;
    }
}
