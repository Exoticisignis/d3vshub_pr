package com.example.infrastructure.api.services;

import com.example.infrastructure.api.DeliveriesApiDelegate;
import com.example.infrastructure.models.DeliveryDTO;
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
    public ResponseEntity<String> deliveriesPost(DeliveryDTO delivery){
        return ResponseEntity.ok().body("Delivery added");
    }

    @Override
    public ResponseEntity<List<DeliveryDTO>>  deliveriesGet(Integer limit){
        List<DeliveryDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> deliveriesIdDelete(Long id){
        return ResponseEntity.ok().body("Delivery deleted");
    }

    @Override
    public ResponseEntity<DeliveryDTO> deliveriesIdGet(Long id){
        DeliveryDTO d = new DeliveryDTO();
        return ResponseEntity.ok().body(d);
    }
}
