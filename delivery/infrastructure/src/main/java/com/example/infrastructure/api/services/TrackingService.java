package com.example.infrastructure.api.services;

import com.example.infrastructure.api.TrackingApiDelegate;
import com.example.infrastructure.models.TrackingDTO;
import com.example.infrastructure.repositories.TrackingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackingService implements TrackingApiDelegate {
    @Autowired
    private TrackingRepo tracking;

    @Override
    public ResponseEntity<String> trackingPost(TrackingDTO tracking){
        return ResponseEntity.ok().body("Tracking added");
    }

    @Override
    public ResponseEntity<List<TrackingDTO>> trackingGet(Integer limit){
        List<TrackingDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> trackingIdDelete(Long id){
        return ResponseEntity.ok().body("Tracking deleted");
    }

    @Override
    public ResponseEntity<TrackingDTO> trackingIdGet(Long id){
        TrackingDTO t = new TrackingDTO();
        return ResponseEntity.ok().body(t);
    }

    @Override
    public ResponseEntity<List<TrackingDTO>> trackingForDeliveryIdGet(Long id){
        List<TrackingDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }
}
