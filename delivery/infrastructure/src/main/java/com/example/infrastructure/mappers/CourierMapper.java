package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Courier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourierMapper implements RowMapper<Courier> {

    @Override
    public Courier mapRow(ResultSet rs, int rowNum) throws SQLException {
        Courier c = new Courier();
        c.setCourierId(rs.getLong("courier_id"));
        c.setName(rs.getString("name"));
        c.setSurname(rs.getString("surname"));
        c.setPhone(rs.getString("phone"));
        c.setSalt(rs.getString("salt"));
        c.setHashedPassword(rs.getString("hashed_password"));
        c.setLogin(rs.getString("login"));
        return null;
    }
}
