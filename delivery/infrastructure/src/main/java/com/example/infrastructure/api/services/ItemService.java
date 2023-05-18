package com.example.infrastructure.api.services;

import com.example.infrastructure.api.ItemsApiDelegate;
import com.example.infrastructure.models.Item;
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
    public ResponseEntity<String> itemsPost(Item item){
        return ResponseEntity.ok().body("Item added");
    }

    @Override
    public ResponseEntity<List<Item>> itemsGet(Integer limit){
        List<Item> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<String> itemsIdDelete(Integer id){
        return ResponseEntity.ok().body("Item deleted");
    }

    @Override
    public ResponseEntity<Item> itemsIdGet(Integer id){
        Item i = new Item();
        return ResponseEntity.ok().body(i);
    }

    @Override
    public ResponseEntity<List<Item>> itemsForOrderOrderIdGet(Integer id){
        List<Item> list = new ArrayList<>();
        return ResponseEntity.ok().body(list);
    }
}
