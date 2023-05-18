package com.example.infrastructure.api.services;

import com.example.infrastructure.api.CustomersApiDelegate;
import com.example.infrastructure.models.Customer;
import com.example.infrastructure.repositories.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements CustomersApiDelegate {
    @Autowired
    private CustomersRepo customers;

    @Override
    public ResponseEntity<String> customersPost(Customer customer){
        return ResponseEntity.ok().body("Customer added");
    }

    @Override
    public ResponseEntity<List<Customer>> customersGet(Integer limit){
        List<Customer> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> customersIdDelete(Long id){
        return ResponseEntity.ok().body("Customer deleted");
    }

    @Override
    public ResponseEntity<Customer> customersIdGet(Long id){
        Customer c = new Customer();
        return ResponseEntity.ok().body(c);
    }
}
