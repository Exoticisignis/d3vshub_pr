package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Courier;
import com.example.infrastructure.entities.Delivery;
import com.example.infrastructure.entities.Order;
import com.example.infrastructure.models.DeliveryDTO;
import com.example.infrastructure.repositories.CouriersRepo;
import com.example.infrastructure.repositories.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DeliveryDTOMapper {
    @Autowired
    public static OrdersRepo orders;
    @Autowired
    public static CouriersRepo couriers;

    public static DeliveryDTO deliveryToDTO(Delivery d){
        DeliveryDTO dto =  new DeliveryDTO();
        dto.setId(d.getId());
        dto.setCourier(d.getCourier().getCourierId());
        dto.setOrder(d.getOrder().getOrderId());
        dto.setDeliveryDate(OffsetDateTime.ofInstant(d.getDeliveryDate(), ZoneOffset.UTC));
        return dto;
    }

    public static Delivery DTOtoEntity(DeliveryDTO dto){
        Delivery d = new Delivery();
        d.setDeliveryDate(dto.getDeliveryDate().toInstant());
        Order o = orders.getReferenceById(dto.getOrder());
        d.setOrder(o);
        Courier c = couriers.getReferenceById(dto.getCourier());
        d.setCourier(c);
        return d;
    }
}
