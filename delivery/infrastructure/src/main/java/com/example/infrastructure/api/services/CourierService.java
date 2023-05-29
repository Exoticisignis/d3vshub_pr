package com.example.infrastructure.api.services;

import com.example.infrastructure.api.CouriersApiDelegate;
import com.example.infrastructure.models.CourierDTO;
import com.example.infrastructure.repositories.CouriersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourierService implements CouriersApiDelegate {
    @Autowired
    private CouriersRepo couriersRepo;

    @Override
    public ResponseEntity<String> temp(){
        return ResponseEntity.ok().body("TEST");
    }
    @Override
    public ResponseEntity<String> couriersPost(CourierDTO courier){
        return ResponseEntity.ok().body("Courier added");
    }

    @Override
    public ResponseEntity<List<CourierDTO>> couriersGet(Integer limit){
        List<CourierDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> couriersIdDelete(Long id){
        return ResponseEntity.ok().body("Courier deleted");
    }

    @Override
    public ResponseEntity<CourierDTO> couriersIdGet(Long id){
        CourierDTO courier = new CourierDTO();
        return ResponseEntity.ok().body(courier);
    }
}
