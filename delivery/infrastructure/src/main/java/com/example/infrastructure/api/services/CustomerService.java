package com.example.infrastructure.api.services;

import com.example.infrastructure.api.CustomersApiDelegate;
import com.example.infrastructure.entities.Customer;
import com.example.infrastructure.mappers.CustomerDTOMapper;
import com.example.infrastructure.models.CustomerDTO;
import com.example.infrastructure.repositories.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements CustomersApiDelegate {
    @Autowired
    private CustomersRepo customers;

    @Override
    public ResponseEntity<String> customersPost(CustomerDTO customer){
        if (customer != null){
            Customer c = CustomerDTOMapper.DTOtoEntity(customer);
            customers.save(c);
            return ResponseEntity.ok().body("Customer added");
        }
        return ResponseEntity.badRequest().body("Null object for customers POST request");
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> customersGet(Integer limit){
        if(limit > 0){
            List<CustomerDTO> result = new ArrayList<>();
            List<Customer> list = customers.getNCustomers(limit);
            for (Customer c : list){
                result.add(CustomerDTOMapper.customerToDTO(c));
            }
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    @Transactional
    public ResponseEntity<String> customersIdDelete(Long id){
        if(customers.existsById(id)){
            customers.deleteById(id);
            return ResponseEntity.ok().body("Customer deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<CustomerDTO> customersIdGet(Long id){
        if(customers.existsById(id)){
            Customer c = customers.getReferenceById(id);
            CustomerDTO customer = CustomerDTOMapper.customerToDTO(c);
            return ResponseEntity.ok().body(customer);
        }
        return ResponseEntity.notFound().build();
    }
}
