package com.example.infrastructure.api.services;

import com.example.infrastructure.api.delegates.TrackingApiDelegate;
import com.example.infrastructure.api.errors.NoSuchElementFoundException;
import com.example.infrastructure.api.errors.NullObjectInRequestBodyEcxeption;
import com.example.infrastructure.entities.Delivery;
import com.example.infrastructure.entities.Tracking;
import com.example.infrastructure.mappers.TrackingDTOMapper;
import com.example.infrastructure.models.TrackingDTO;
import com.example.infrastructure.repositories.DeliveriesRepo;
import com.example.infrastructure.repositories.TrackingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (tracking == null){
            throw new NullObjectInRequestBodyEcxeption("Null value in request body");
        }
        Tracking t = TrackingDTOMapper.DTOtoEntity(tracking);
        Delivery d = deliveries.getReferenceById(tracking.getDelivery());
        t.setDelivery(d);
        trackingRepo.save(t);
        return ResponseEntity.ok().body("Tracking added");
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
    @Transactional
    public ResponseEntity<String> trackingIdDelete(Long id){
        if(!trackingRepo.existsById(id)){
            throw new NoSuchElementFoundException("Tracking with ID "+ id +" not found");
        }
        trackingRepo.deleteById(id);
        return ResponseEntity.ok().body("Tracking deleted");
    }

    @Override
    public ResponseEntity<TrackingDTO> trackingIdGet(Long id){
        if(!trackingRepo.existsById(id)){
            throw new NoSuchElementFoundException("Tracking with ID "+ id +" not found");
        }
        Tracking entity = trackingRepo.getReferenceById(id);
        TrackingDTO dto = TrackingDTOMapper.trackingToDTO(entity);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<TrackingDTO> trackingForDeliveryIdGet(Long id){
        if(!deliveries.existsById(id)){
            throw new NoSuchElementFoundException("Delivery with ID "+ id +" not found");
        }
        Tracking t = trackingRepo.getTrackingForDeliveryId(id);
        return ResponseEntity.ok().body(TrackingDTOMapper.trackingToDTO(t));
    }
}
