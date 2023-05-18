package com.example.infrastructure.api.services;

import com.example.infrastructure.api.OrdersApiDelegate;
import com.example.infrastructure.models.Order;
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
    public ResponseEntity<String> ordersPost(Order order){
        return ResponseEntity.ok().body("Order added");
    }

    @Override
    public ResponseEntity<List<Order>> ordersGet(Integer limit){
        List<Order> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> ordersIdDelete(Integer id){
        return ResponseEntity.ok().body("Order deleted");
    }

    @Override
    public ResponseEntity<Order> ordersIdGet(Integer id){
        Order o = new Order();
        return ResponseEntity.ok().body(o);
    }

    @Override
    public ResponseEntity<List<Order>> ordersForItemIdGet(Integer id){
        List<Order> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }
}
