package com.example.infrastructure.api.services;

import com.example.infrastructure.api.ItemsApiDelegate;
import com.example.infrastructure.models.ItemDTO;
import com.example.infrastructure.repositories.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements ItemsApiDelegate {
    @Autowired
    private ItemsRepo items;

    @Override
    public ResponseEntity<String> itemsPost(ItemDTO item){
        return ResponseEntity.ok().body("Item added");
    }

    @Override
    public ResponseEntity<List<ItemDTO>> itemsGet(Integer limit){
        List<ItemDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> itemsIdDelete(Long id){
        return ResponseEntity.ok().body("Item deleted");
    }

    @Override
    public ResponseEntity<ItemDTO> itemsIdGet(Long id){
        ItemDTO i = new ItemDTO();
        return ResponseEntity.ok().body(i);
    }

    @Override
    public ResponseEntity<List<ItemDTO>> itemsForOrderOrderIdGet(Integer id){
        List<ItemDTO> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }
}
