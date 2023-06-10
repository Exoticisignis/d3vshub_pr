package com.example.infrastructure.api.services;

import com.example.infrastructure.api.CustomersApiDelegate;
import com.example.infrastructure.api.errors.NoSuchElementFoundException;
import com.example.infrastructure.api.errors.NullObjectInRequestBodyEcxeption;
import com.example.infrastructure.api.errors.UserExistsException;
import com.example.infrastructure.entities.Customer;
import com.example.infrastructure.mappers.CustomerDTOMapper;
import com.example.infrastructure.models.CustomerDTO;
import com.example.infrastructure.repositories.CustomersRepo;
import com.example.infrastructure.security.PasswordHasher;
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
    public ResponseEntity<String> customersPost(CustomerDTO customer) throws UserExistsException {
        if (customer == null){
            throw new NullObjectInRequestBodyEcxeption("Null value in request body");
        }
        if (customers.existsByEmail(customer.getLogin()))
            throw new UserExistsException("Email already in use");
        String hPassword = PasswordHasher.hashPassword(customer.getPassword(), customer.getSalt());
        Customer c = CustomerDTOMapper.DTOtoEntity(customer);
        c.setHashedPassword(hPassword);
        customers.save(c);
        return ResponseEntity.ok().body("Customer added");
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
        if(!customers.existsById(id)){
            throw new NoSuchElementFoundException("Customer with ID "+ id +" not found");
        }
        customers.deleteById(id);
        return ResponseEntity.ok().body("Customer deleted");
    }
    @Override
    public ResponseEntity<CustomerDTO> customersIdGet(Long id){
        if(!customers.existsById(id)){
            throw new NoSuchElementFoundException("Customer with ID "+ id +" not found");
        }
        Customer c = customers.getReferenceById(id);
        CustomerDTO customer = CustomerDTOMapper.customerToDTO(c);
        return ResponseEntity.ok().body(customer);
    }
/*
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

 */
}
