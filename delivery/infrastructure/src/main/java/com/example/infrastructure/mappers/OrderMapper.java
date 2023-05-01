package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order o = new Order();
        o.setOrderId(rs.getLong("order_id"));
        o.setTotalPrice(rs.getDouble("total_price"));
        o.setOrderDate(rs.getTimestamp("order_date").toInstant());
        return null;
    }
}
