package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Customer;
import com.example.infrastructure.entities.Order;
import com.example.infrastructure.entities.OrderItem;
import com.example.infrastructure.models.OrderDTO;
import com.example.infrastructure.repositories.CustomersRepo;
import com.example.infrastructure.repositories.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class OrderDTOMapper {
    @Autowired
    public static CustomersRepo customers;
    @Autowired
    public static ItemsRepo items;

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

    public static Order DTOtoEntity(OrderDTO dto){
        Order o = new Order();
        Customer c = customers.getReferenceById(dto.getCustomer());
        o.setCustomer(c);
        o.setAddress(dto.getAddress());
        o.setOrderDate(dto.getOrderDate().toInstant());
        o.setTotalPrice(dto.getTotalPrice());
        List<OrderItem> orderItems = new ArrayList<>();
        for (String name : dto.getOrderItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(o);
            orderItem.setItem(items.findByName(name));
            if (orderItems.contains(orderItem)){
                //index variable is used to keep code readable
                int index = orderItems.indexOf(orderItem);
                //if orderItems contains item for this order, change quantity of item for order
                orderItems.get(index).setQuantity(orderItem.getQuantity()+1);
            }
            else{
                orderItem.setQuantity(1);
                orderItems.add(orderItem);
            }
        }
        o.setOrderItems(orderItems);
        return o;
    }
}
