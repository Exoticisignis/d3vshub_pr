package com.example.infrastructure.api.services;

import com.example.infrastructure.api.TrackingApiDelegate;
import com.example.infrastructure.entities.Order;
import com.example.infrastructure.entities.Tracking;
import com.example.infrastructure.mappers.OrderDTOMapper;
import com.example.infrastructure.mappers.TrackingDTOMapper;
import com.example.infrastructure.models.OrderDTO;
import com.example.infrastructure.models.TrackingDTO;
import com.example.infrastructure.repositories.DeliveriesRepo;
import com.example.infrastructure.repositories.TrackingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackingService implements TrackingApiDelegate {
    @Autowired
    private TrackingRepo trackingRepo;
    @Autowired
    private DeliveriesRepo deliveries;

    @Override
    public ResponseEntity<String> trackingPost(TrackingDTO tracking){
        if (tracking != null){
            Tracking t = TrackingDTOMapper.DTOtoEntity(tracking);
            trackingRepo.save(t);
            return ResponseEntity.ok().body("Tracking added");
        }
        return ResponseEntity.badRequest().body("Null object for tracking POST request");
    }

    @Override
    public ResponseEntity<List<TrackingDTO>> trackingGet(Integer limit){
        if(limit > 0){
            List<TrackingDTO> result = new ArrayList<>();
            List<Tracking> list = trackingRepo.getNTracking(limit);
            for (Tracking t : list){
                result.add(TrackingDTOMapper.trackingToDTO(t));
            }
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<String> trackingIdDelete(Long id){
        if(trackingRepo.existsById(id)){
            trackingRepo.deleteById(id);
            return ResponseEntity.ok().body("Tracking deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<TrackingDTO> trackingIdGet(Long id){
        if(trackingRepo.existsById(id)){
            Tracking entity = trackingRepo.getReferenceById(id);
            TrackingDTO dto = TrackingDTOMapper.trackingToDTO(entity);
            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<TrackingDTO> trackingForDeliveryIdGet(Long id){
        if(deliveries.existsById(id)){
            Tracking t = trackingRepo.getTrackingForDeliveryId(id);
            return ResponseEntity.ok().body(TrackingDTOMapper.trackingToDTO(t));
        }
        return ResponseEntity.notFound().build();
    }
}
