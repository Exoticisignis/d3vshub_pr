package com.example.infrastructure.api.services;

import com.example.infrastructure.api.CouriersApiDelegate;
import com.example.infrastructure.api.errors.NoSuchElementFoundException;
import com.example.infrastructure.api.errors.NullObjectInRequestBodyEcxeption;
import com.example.infrastructure.api.errors.UserExistsException;
import com.example.infrastructure.entities.Courier;
import com.example.infrastructure.mappers.CourierDTOMapper;
import com.example.infrastructure.models.CourierDTO;
import com.example.infrastructure.repositories.CouriersRepo;
import com.example.infrastructure.security.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

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
    public ResponseEntity<String> couriersPost(CourierDTO courier) throws UserExistsException {
        if (courier == null){
            throw new NullObjectInRequestBodyEcxeption("Null value in request body");
        }
        if (couriersRepo.existsByLogin(courier.getLogin()))
            throw new UserExistsException("Login already in use");
        String hPassword = PasswordHasher.hashPassword(courier.getPassword(), courier.getSalt());
        Courier c = CourierDTOMapper.DTOtoEntity(courier);
        c.setHashedPassword(hPassword);
        couriersRepo.save(c);
        return ResponseEntity.ok().body("Courier added");
    }

    @Override
    public ResponseEntity<List<CourierDTO>> couriersGet(Integer limit){
        List<CourierDTO> result = new ArrayList<>();
        List<Courier> list = couriersRepo.getNCouriers(limit);
        for (Courier c : list){
            result.add(CourierDTOMapper.courierToDTO(c));
        }
        return ResponseEntity.ok().body(result);
    }

    /*
    @Override
    @Transactional
    public ResponseEntity<String> couriersIdDelete(Long id){
        if(couriersRepo.existsById(id)){
            couriersRepo.deleteById(id);
            return ResponseEntity.ok().body("Courier deleted");
        }
        return ResponseEntity.notFound().build();
    }*/

    @Override
    @Transactional
    public ResponseEntity<String> couriersIdDelete(Long id){
        if(!couriersRepo.existsById(id))
            throw new NoSuchElementFoundException("Courier with ID "+ id +" not found");
        couriersRepo.deleteById(id);
        return ResponseEntity.ok().body("Courier deleted");
    }
    /*

    @Override
    public ResponseEntity<CourierDTO> couriersIdGet(Long id){
        if(couriersRepo.existsById(id)){
            Courier c = couriersRepo.getReferenceById(id);
            CourierDTO courier = CourierDTOMapper.courierToDTO(c);
            return ResponseEntity.ok().body(courier);
        }
        return ResponseEntity.notFound().build();
    }
    */

    @Override
    public ResponseEntity<CourierDTO> couriersIdGet(Long id){
        Courier c = couriersRepo.findById(id).orElseThrow(()
                -> new NoSuchElementFoundException("Courier with ID "+ id +" not found"));
        CourierDTO courier = CourierDTOMapper.courierToDTO(c);
        return ResponseEntity.ok().body(courier);
    }
}
