package com.example.infrastructure.api.services;

import com.example.infrastructure.api.OrdersApiDelegate;
import com.example.infrastructure.entities.Customer;
import com.example.infrastructure.entities.Item;
import com.example.infrastructure.entities.Order;
import com.example.infrastructure.entities.OrderItem;
import com.example.infrastructure.mappers.OrderDTOMapper;
import com.example.infrastructure.models.OrderDTO;
import com.example.infrastructure.repositories.CustomersRepo;
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
public class OrderService implements OrdersApiDelegate {
    @Autowired
    private OrdersRepo orders;
    @Autowired
    private ItemsRepo itemsRepo;
    @Autowired
    private OrderItemRepo orderItemsRepo;
    @Autowired
    private CustomersRepo customers;
    @Autowired
    private ItemService itemService;

    @Override
    @Transactional
    public ResponseEntity<String> ordersPost(OrderDTO order){
        //totalPrice is recalculated because I don't trust frontend dev
        if (order != null){
            Order o = OrderDTOMapper.DTOtoEntity(order);
            Customer c = customers.getReferenceById(order.getCustomer());
            o.setCustomer(c);
            double price = 0;
            List<OrderItem> orderItems = listItemsToOrderItems(order.getOrderItems());
            for (OrderItem oI : orderItems) {
                Item i = oI.getItem();
                int quantity = oI.getQuantity();
                int result = itemService.getItemForOrder(i.getItemId(), quantity);
                if (result == -1)
                    return ResponseEntity.badRequest().body("Unavailable amount of item: " + i.getItemName());
                double itemPrice = oI.getItem().getPrice() * oI.getQuantity();
                price+=itemPrice;
            }
            o.setTotalPrice(price);
            orders.saveAndFlush(o);
            for (OrderItem oI: o.getOrderItems()) {
                oI.setOrder(o);
                orderItemsRepo.save(oI);
            }
            return ResponseEntity.ok().body("Order added");
        }
        return ResponseEntity.badRequest().body("Null object for orders POST request");
    }
    public List<OrderItem> listItemsToOrderItems(List<String> list){
        List<OrderItem> orderItems = new ArrayList<>();
        for (String name : list){
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(itemsRepo.findByName(name));
            if (orderItems.contains(orderItem)){
                //index variable is used to keep code readable
                int index = orderItems.indexOf(orderItem);
                //if orderItems contains item for this order, change quantity of item for order
                orderItems.get(index).setQuantity(orderItem.getQuantity()+1);
            }
            else{
                orderItem.setQuantity(1);
                orderItems.add(orderItem);
            }
        }
        return orderItems;
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersGet(Integer limit){
        if(limit > 0){
            List<OrderDTO> result = new ArrayList<>();
            List<Order> list = orders.getNOrders(limit);
            for (Order o : list){
                result.add(OrderDTOMapper.orderToDTO(o));
            }
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    @Transactional
    public ResponseEntity<String> ordersIdDelete(Long id){
        if(orders.existsById(id)){
            orders.deleteById(id);
            return ResponseEntity.ok().body("Order deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<OrderDTO> ordersIdGet(Long id){
        if(orders.existsById(id)){
            Order entity = orders.getReferenceById(id);
            OrderDTO dto = OrderDTOMapper.orderToDTO(entity);
            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersCustomerIdGet(Long id){
        if(customers.existsById(id)){
            List<Order> orderList = orders.getOrdersForCustomerId(id);
            List<OrderDTO> result = new ArrayList<>();
            for (Order o : orderList){
                result.add(OrderDTOMapper.orderToDTO(o));
            }
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersForItemIdGet(Long id){
        if(itemsRepo.existsById(id)){
            List<OrderItem> orderItemsList = orderItemsRepo.getOrdersForItemId(id);
            List<OrderDTO> dtoList = new ArrayList<>();
            for (OrderItem oI : orderItemsList){
                dtoList.add(OrderDTOMapper.orderToDTO(oI.getOrder()));
            }
            return ResponseEntity.ok().body(dtoList);
        }
        return ResponseEntity.notFound().build();
    }
}
