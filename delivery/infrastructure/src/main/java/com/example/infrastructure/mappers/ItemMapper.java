package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item i = new Item();
        i.setItemId(rs.getLong("item_id"));
        i.setItemName(rs.getString("name"));
        i.setCategory(rs.getString("category"));
        i.setDescription(rs.getString("description"));
        i.setAllergenInfo(rs.getString("allergen_info"));
        i.setImageUrl(rs.getString("image_url"));
        i.setQuantity(rs.getInt("quantity"));
        i.setPrice(rs.getDouble("price"));
        return i;
    }
}
