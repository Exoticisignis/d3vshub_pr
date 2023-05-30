package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Delivery;
import com.example.infrastructure.models.DeliveryDTO;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DeliveryDTOMapper {

    public static DeliveryDTO deliveryToDTO(Delivery d){
        DeliveryDTO dto =  new DeliveryDTO();
        dto.setId(d.getId());
        dto.setCourier(d.getCourier().getCourierId());
        dto.setOrder(d.getOrder().getOrderId());
        dto.setDeliveryDate(OffsetDateTime.ofInstant(d.getDeliveryDate(), ZoneOffset.UTC));
        return dto;
    }
}
