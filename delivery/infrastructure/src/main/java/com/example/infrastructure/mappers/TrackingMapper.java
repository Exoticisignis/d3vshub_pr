package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Tracking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackingMapper implements RowMapper<Tracking> {
    @Override
    public Tracking mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tracking t = new Tracking();
        t.setId(rs.getLong("tracking_id"));
        t.setLocation(rs.getString("location"));
        t.setStatus(rs.getString("status"));
        t.setUpdateTime(rs.getTimestamp("update_date").toInstant());
        t.setDelivery(new DeliveryMapper().mapRow(rs, rowNum));
        return t;
    }
}
