package com.example.infrastructure.mappers;

import com.example.infrastructure.entities.Item;
import com.example.infrastructure.models.ItemDTO;

public class ItemDTOMapper {

    public static ItemDTO itemToDTO(Item i){
        ItemDTO dto = new ItemDTO();
        dto.setId(i.getItemId());
        dto.setName(i.getItemName());
        dto.setCategory(i.getCategory());
        dto.setAllergenInfo(i.getAllergenInfo());
        dto.setDescription(i.getDescription());
        dto.setPrice(i.getPrice());
        dto.setQuantity(i.getQuantity());
        dto.setImageUrl(i.getImageUrl());
        return dto;
    }

    public static Item DTOtoEntity(ItemDTO dto){
        Item i = new Item();
        i.setItemName(dto.getName());
        i.setCategory(dto.getCategory());
        i.setPrice(dto.getPrice());
        i.setDescription(dto.getDescription());
        i.setAllergenInfo(dto.getAllergenInfo());
        i.setQuantity(dto.getQuantity());
        i.setImageUrl(dto.getImageUrl());
        return i;
    }
}
