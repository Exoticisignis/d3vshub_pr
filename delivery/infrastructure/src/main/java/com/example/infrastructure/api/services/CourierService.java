package com.example.infrastructure.api.services;

import com.example.infrastructure.api.CouriersApiDelegate;
import com.example.infrastructure.entities.Courier;
import com.example.infrastructure.mappers.CourierDTOMapper;
import com.example.infrastructure.models.CourierDTO;
import com.example.infrastructure.repositories.CouriersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (courier != null){
            Courier c = CourierDTOMapper.DTOtoEntity(courier);
            couriersRepo.save(c);
            return ResponseEntity.ok().body("Courier added");
        }
        return ResponseEntity.badRequest().body("Null object for couriers POST request");
    }

    @Override
    public ResponseEntity<List<CourierDTO>> couriersGet(Integer limit){
        if(limit > 0){
            List<CourierDTO> result = new ArrayList<>();
            List<Courier> list = couriersRepo.getNCouriers(limit);
            for (Courier c : list){
                result.add(CourierDTOMapper.courierToDTO(c));
            }
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    @Transactional
    public ResponseEntity<String> couriersIdDelete(Long id){
        if(couriersRepo.existsById(id)){
            couriersRepo.deleteById(id);
            return ResponseEntity.ok().body("Courier deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<CourierDTO> couriersIdGet(Long id){
        if(couriersRepo.existsById(id)){
            Courier c = couriersRepo.getReferenceById(id);
            CourierDTO courier = CourierDTOMapper.courierToDTO(c);
            return ResponseEntity.ok().body(courier);
        }
        return ResponseEntity.notFound().build();
    }
}
