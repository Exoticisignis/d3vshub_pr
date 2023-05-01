package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer>{
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer c = new Customer();
        c.setCustomerId(resultSet.getLong("customer_id"));
        c.setName(resultSet.getString("name"));
        c.setSurname(resultSet.getString("surname"));
        c.setAddress(resultSet.getString("address"));
        c.setPhone(resultSet.getString("phone"));
        c.setEmail(resultSet.getString("email"));
        c.setSalt(resultSet.getString("salt"));
        c.setHashedPassword(resultSet.getString("hashed_password"));
        return c;
    }
}
