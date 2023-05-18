package com.example.infrastructure.api.services;

import com.example.infrastructure.api.DeliveriesApiDelegate;
import com.example.infrastructure.models.Delivery;
import com.example.infrastructure.repositories.DeliveriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService implements DeliveriesApiDelegate {
    @Autowired
    private DeliveriesRepo deliveries;

    @Override
    public ResponseEntity<String> deliveriesPost(Delivery delivery){
        return ResponseEntity.ok().body("Delivery added");
    }

    @Override
    public ResponseEntity<List<Delivery>>  deliveriesGet(Integer limit){
        List<Delivery> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> deliveriesIdDelete(Long id){
        return ResponseEntity.ok().body("Delivery deleted");
    }

    @Override
    public ResponseEntity<Delivery> deliveriesIdGet(Long id){
        Delivery d = new Delivery();
        return ResponseEntity.ok().body(d);
    }
}
