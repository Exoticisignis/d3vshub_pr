package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem oI = new OrderItem();
        oI.setQuantity(rs.getInt("quantity"));
        return null;
    }
}
