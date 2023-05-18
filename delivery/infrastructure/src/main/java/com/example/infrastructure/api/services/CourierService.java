package com.example.infrastructure.api.services;

import com.example.infrastructure.api.CouriersApiDelegate;
import com.example.infrastructure.models.Courier;
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
    public ResponseEntity<String> couriersPost(Courier courier){
        return ResponseEntity.ok().body("Courier added");
    }

    @Override
    public ResponseEntity<List<Courier>> couriersGet(Integer limit){
        List<Courier> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> couriersIdDelete(Integer id){
        return ResponseEntity.ok().body("Courier deleted");
    }

    @Override
    public ResponseEntity<Courier> couriersIdGet(Integer id){
        Courier courier = new Courier();
        return ResponseEntity.ok().body(courier);
    }
}
