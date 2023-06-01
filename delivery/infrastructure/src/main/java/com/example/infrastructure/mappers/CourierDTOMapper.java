package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Courier;
import com.example.infrastructure.models.CourierDTO;
import com.example.infrastructure.repositories.CouriersRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CourierDTOMapper {

    public static CourierDTO courierToDTO(Courier c){
        CourierDTO dto = new CourierDTO();
        dto.setId(c.getCourierId());
        dto.setName(c.getName());
        dto.setSurname(c.getSurname());
        dto.setLogin(c.getLogin());
        dto.setPassword(c.getHashedPassword());
        dto.setSalt(c.getSalt());
        dto.setPhone(c.getPhone());
        return dto;
    }

    public static Courier DTOtoEntity(CourierDTO dto){
        Courier c = new Courier();
        c.setName(dto.getName());
        c.setSurname(dto.getSurname());
        c.setLogin(dto.getLogin());
        c.setSalt(dto.getSalt());
        c.setHashedPassword(dto.getPassword());
        c.setPhone(dto.getPhone());
        return c;
    }

}
