package com.example.infrastructure.api.services;

import com.example.infrastructure.api.TrackingApiDelegate;
import com.example.infrastructure.models.Tracking;
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
    public ResponseEntity<String> trackingPost(Tracking tracking){
        return ResponseEntity.ok().body("Tracking added");
    }

    @Override
    public ResponseEntity<List<Tracking>> trackingGet(Integer limit){
        List<Tracking> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> trackingIdDelete(Integer id){
        return ResponseEntity.ok().body("Tracking deleted");
    }

    @Override
    public ResponseEntity<Tracking> trackingIdGet(Integer id){
        Tracking t = new Tracking();
        return ResponseEntity.ok().body(t);
    }

    @Override
    public ResponseEntity<List<Tracking>> trackingForDeliveryIdGet(Integer id){
        List<Tracking> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }
}
