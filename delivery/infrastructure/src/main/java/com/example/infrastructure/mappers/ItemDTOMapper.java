package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Item;
import com.example.infrastructure.models.ItemDTO;

public class ItemDTOMapper {

    public static ItemDTO itemToDTO(Item i){
        ItemDTO dto = new ItemDTO();
        dto.setId(i.getItemId());
        dto.setCategory(i.getCategory());
        dto.setAllergenInfo(i.getAllergenInfo());
        dto.setDescription(i.getDescription());
        dto.setPrice(i.getPrice());
        dto.setQuantity(i.getQuantity());
        dto.setImageUrl(i.getImageUrl());
        return dto;
    }
}
