package com.example.infrastructure.api.services;

import com.example.infrastructure.api.ItemsApiDelegate;
import com.example.infrastructure.api.errors.NoSuchElementFoundException;
import com.example.infrastructure.api.errors.NullObjectInRequestBodyEcxeption;
import com.example.infrastructure.entities.Item;
import com.example.infrastructure.entities.OrderItem;
import com.example.infrastructure.mappers.ItemDTOMapper;
import com.example.infrastructure.models.ItemDTO;
import com.example.infrastructure.repositories.ItemsRepo;
import com.example.infrastructure.repositories.OrderItemRepo;
import com.example.infrastructure.repositories.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements ItemsApiDelegate {
    @Autowired
    private ItemsRepo items;
    @Autowired
    private OrderItemRepo orderItems;
    @Autowired
    private OrdersRepo orders;

    @Transactional
    public int getItemForOrder(Long id, int quantity){
        Item i = items.getReferenceById(id);
        int newQuantity = i.getQuantity() - quantity;
        if (newQuantity >= 0){
            i.setQuantity(newQuantity);
            items.saveAndFlush(i);
            return 0;
        }
        else {
            return -1;
        }
    }

    @Override
    public ResponseEntity<String> itemsPost(ItemDTO item){
        if (item == null){
            throw new NullObjectInRequestBodyEcxeption("Null value in request body");
        }
        Item i = ItemDTOMapper.DTOtoEntity(item);
        items.save(i);
        return ResponseEntity.ok().body("Item added");
    }

    @Override
    public ResponseEntity<List<ItemDTO>> itemsGet(Integer limit){
        if(limit > 0){
            List<ItemDTO> result = new ArrayList<>();
            List<Item> list = items.getNItems(limit);
            for (Item i : list){
                result.add(ItemDTOMapper.itemToDTO(i));
            }
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    @Transactional
    public ResponseEntity<String> itemsIdDelete(Long id){
        if(!items.existsById(id)){
            throw new NoSuchElementFoundException("Item with ID "+ id +" not found");
        }
        items.deleteById(id);
        return ResponseEntity.ok().body("Item deleted");
    }

    @Override
    public ResponseEntity<ItemDTO> itemsIdGet(Long id){
        if(!items.existsById(id)){
            throw new NoSuchElementFoundException("Item with ID "+ id +" not found");
        }
        Item entity = items.getReferenceById(id);
        ItemDTO dto = ItemDTOMapper.itemToDTO(entity);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<ItemDTO>> itemsForOrderOrderIdGet(Long id){
        if(!orders.existsById(id)){
            throw new NoSuchElementFoundException("Order with ID "+ id +" not found");
        }
        List<OrderItem> orderItemsList = orderItems.getItemsForOrderId(id);
        List<ItemDTO> dtoList = new ArrayList<>();
        for (OrderItem oI : orderItemsList){
            dtoList.add(ItemDTOMapper.itemToDTO(oI.getItem()));
        }
        return ResponseEntity.ok().body(dtoList);
    }
}
