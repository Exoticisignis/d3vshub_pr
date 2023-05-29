package com.example.infrastructure.api.services;

import com.example.infrastructure.api.OrdersApiDelegate;
import com.example.infrastructure.models.OrderDTO;
import com.example.infrastructure.repositories.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrdersApiDelegate {
    @Autowired
    private OrdersRepo orders;

    @Override
    public ResponseEntity<String> ordersPost(OrderDTO order){
        return ResponseEntity.ok().body("Order added");
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersGet(Integer limit){
        List<OrderDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> ordersIdDelete(Long id){
        return ResponseEntity.ok().body("Order deleted");
    }

    @Override
    public ResponseEntity<OrderDTO> ordersIdGet(Long id){
        OrderDTO o = new OrderDTO();
        return ResponseEntity.ok().body(o);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersCustomerIdGet(Long id){
        List<OrderDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersForItemIdGet(Long id){
        List<OrderDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }
}
