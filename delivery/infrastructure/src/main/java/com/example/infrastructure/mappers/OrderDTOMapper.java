package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Order;
import com.example.infrastructure.entities.OrderItem;
import com.example.infrastructure.models.OrderDTO;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class OrderDTOMapper {

    public static OrderDTO orderToDTO(Order o){
        OrderDTO dto = new OrderDTO();
        dto.setId(o.getOrderId());
        dto.setOrderDate(OffsetDateTime.ofInstant(o.getOrderDate(), ZoneOffset.UTC));
        List<String> items = new ArrayList<>();
        for(OrderItem i : o.getOrderItems())
            items.add(i.getItem().getItemName());
        dto.setOrderItems(items);
        dto.setAddress(o.getAddress());
        dto.setTotalPrice(o.getTotalPrice());
        dto.setCustomer(o.getCustomer().getCustomerId());
        return dto;
    }
}
