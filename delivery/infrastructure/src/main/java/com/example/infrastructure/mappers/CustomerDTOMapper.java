package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Customer;
import com.example.infrastructure.models.CustomerDTO;

public class CustomerDTOMapper {
    public static CustomerDTO customerToDTO(Customer c){
        CustomerDTO dto = new CustomerDTO();
        dto.setId(c.getCustomerId());
        dto.setName(c.getName());
        dto.setSurname(c.getSurname());
        dto.setAddress(c.getAddress());
        dto.setLogin(c.getEmail());
        dto.setPhone(c.getPhone());
        dto.setSalt(c.getSalt());
        dto.setPassword(c.getHashedPassword());
        return dto;
    }
}
