package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Courier;
import com.example.infrastructure.entities.Delivery;
import com.example.infrastructure.entities.Order;
import com.example.infrastructure.models.DeliveryDTO;
import com.example.infrastructure.repositories.CouriersRepo;
import com.example.infrastructure.repositories.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DeliveryDTOMapper {

    public static DeliveryDTO deliveryToDTO(Delivery d){
        DeliveryDTO dto =  new DeliveryDTO();
        dto.setId(d.getId());
        dto.setCourier(d.getCourier().getCourierId());
        dto.setOrder(d.getOrder().getOrderId());
        dto.setDeliveryDate(d.getDeliveryDate().toString());
        return dto;
    }

    public static Delivery DTOtoEntity(DeliveryDTO dto){
        Delivery d = new Delivery();
        d.setDeliveryDate(Timestamp.valueOf(dto.getDeliveryDate()));
        return d;
    }
}
