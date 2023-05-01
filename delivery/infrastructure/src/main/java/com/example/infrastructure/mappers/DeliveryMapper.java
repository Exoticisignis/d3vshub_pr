package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Delivery;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryMapper implements RowMapper<Delivery> {
    @Override
    public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
        Delivery d = new Delivery();
        d.setId(rs.getLong("delivery_id"));
        d.setDeliveryDate(rs.getTimestamp("delivery_date").toInstant());
        return null;
    }
}
