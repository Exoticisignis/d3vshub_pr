package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.OrderItem;
import com.example.infrastructure.entities.OrderItemId;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem oI = new OrderItem();
        OrderItemId orderItemId = new OrderItemId();
        orderItemId.setOrderId(rs.getLong("order_id"));
        orderItemId.setItemId(rs.getLong("item_id"));
        oI.setId(orderItemId);
        oI.setQuantity(rs.getInt("quantity"));
        oI.setItem(new ItemMapper().mapRow(rs, rowNum));
        oI.setOrder(new OrderMapper().mapRow(rs, rowNum));
        return oI;
    }
    public List<OrderItem> mapRowList(ResultSet rs) throws SQLException {
        List<OrderItem> orderItems = new ArrayList<>();
        while (rs.next()) {
            OrderItem orderItem = mapRow(rs, rs.getRow());
            orderItems.add(orderItem);
        }
        return orderItems;
    }
}
