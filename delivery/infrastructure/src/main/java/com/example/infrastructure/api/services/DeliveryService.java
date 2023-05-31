package com.example.infrastructure.api.services;

import com.example.infrastructure.api.DeliveriesApiDelegate;
import com.example.infrastructure.entities.Delivery;
import com.example.infrastructure.mappers.DeliveryDTOMapper;
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
        if (delivery != null){
            Delivery d = DeliveryDTOMapper.DTOtoEntity(delivery);
            deliveries.save(d);
            return ResponseEntity.ok().body("Delivery added");
        }
        return ResponseEntity.badRequest().body("Null object for deliveries POST request");
    }

    @Override
    public ResponseEntity<List<DeliveryDTO>>  deliveriesGet(Integer limit){
        if(limit > 0){
            List<DeliveryDTO> result = new ArrayList<>();
            List<Delivery> list = deliveries.getNDeliveries(limit);
            for (Delivery d : list){
                result.add(DeliveryDTOMapper.deliveryToDTO(d));
            }
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<String> deliveriesIdDelete(Long id){
        if(deliveries.existsById(id)){
            deliveries.deleteById(id);
            return ResponseEntity.ok().body("Delivery deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<DeliveryDTO> deliveriesIdGet(Long id){
        if(deliveries.existsById(id)){
            Delivery entity = deliveries.getReferenceById(id);
            DeliveryDTO dto = DeliveryDTOMapper.deliveryToDTO(entity);
            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.notFound().build();
    }
}
