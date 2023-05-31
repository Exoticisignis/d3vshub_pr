package com.example.infrastructure.api.services;

import com.example.infrastructure.api.ItemsApiDelegate;
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

    @Override
    public ResponseEntity<String> itemsPost(ItemDTO item){
        if (item != null){
            Item i = ItemDTOMapper.DTOtoEntity(item);
            items.save(i);
            return ResponseEntity.ok().body("Item added");
        }
        return ResponseEntity.badRequest().body("Null object for items POST request");
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
    public ResponseEntity<String> itemsIdDelete(Long id){
        if(items.existsById(id)){
            items.deleteById(id);
            return ResponseEntity.ok().body("Item deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<ItemDTO> itemsIdGet(Long id){
        if(items.existsById(id)){
            Item entity = items.getReferenceById(id);
            ItemDTO dto = ItemDTOMapper.itemToDTO(entity);
            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<ItemDTO>> itemsForOrderOrderIdGet(Long id){
        if(orders.existsById(id)){
            List<OrderItem> orderItemsList = orderItems.getItemsForOrderId(id);
            List<ItemDTO> dtoList = new ArrayList<>();
            for (OrderItem oI : orderItemsList){
                dtoList.add(ItemDTOMapper.itemToDTO(oI.getItem()));
            }
            return ResponseEntity.ok().body(dtoList);
        }
        return ResponseEntity.notFound().build();
    }
}
