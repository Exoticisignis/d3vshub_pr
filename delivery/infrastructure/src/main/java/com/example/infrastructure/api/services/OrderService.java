package com.example.infrastructure.api.services;

import com.example.infrastructure.api.delegates.OrdersApiDelegate;
import com.example.infrastructure.api.errors.NoSuchElementFoundException;
import com.example.infrastructure.api.errors.NullObjectInRequestBodyEcxeption;
import com.example.infrastructure.entities.*;
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
        if (order == null){
            throw new NullObjectInRequestBodyEcxeption("Null value in request body");
        }
        Order o = OrderDTOMapper.DTOtoEntity(order);
        Customer c = customers.getReferenceById(order.getCustomer());
        o.setCustomer(c);
        o.setOrderItems(new ArrayList<>());
        //totalPrice is recalculated because I don't trust frontend dev
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
        o.setOrderItems(orderItems);
        return ResponseEntity.ok().body("Order added");
    }
    public List<OrderItem> listItemsToOrderItems(List<String> list){
        List<OrderItem> orderItems = new ArrayList<>();
        for (String name : list){
            OrderItem orderItem = new OrderItem();
            OrderItemId id = new OrderItemId();
            orderItem.setId(id);
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
        if(!orders.existsById(id)){
            throw new NoSuchElementFoundException("Order with ID "+ id +" not found");
        }
        orders.deleteById(id);
        return ResponseEntity.ok().body("Order deleted");
    }

    @Override
    public ResponseEntity<OrderDTO> ordersIdGet(Long id){
        if(!orders.existsById(id)){
            throw new NoSuchElementFoundException("Order with ID "+ id +" not found");
        }
        Order entity = orders.getReferenceById(id);
        OrderDTO dto = OrderDTOMapper.orderToDTO(entity);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersCustomerIdGet(Long id){
        if(!customers.existsById(id)){
            throw new NoSuchElementFoundException("Customer with ID "+ id +" not found");
        }
        List<Order> orderList = orders.getOrdersForCustomerId(id);
        List<OrderDTO> result = new ArrayList<>();
        for (Order o : orderList){
            result.add(OrderDTOMapper.orderToDTO(o));
        }
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> ordersForItemIdGet(Long id){
        if(!itemsRepo.existsById(id)){
            throw new NoSuchElementFoundException("Item with ID "+ id +" not found");
        }
        List<OrderItem> orderItemsList = orderItemsRepo.getOrdersForItemId(id);
        List<OrderDTO> dtoList = new ArrayList<>();
        for (OrderItem oI : orderItemsList){
            dtoList.add(OrderDTOMapper.orderToDTO(oI.getOrder()));
        }
        return ResponseEntity.ok().body(dtoList);
    }
    @Override
    public ResponseEntity<List<OrderDTO>> ordersInDates(String dates){
        String [] s = dates.split(" ");
        String fromDate = s[0];
        String toDate = s[1];
        List<Order> ordersDB = orders.getOrdersInDates(fromDate, toDate);
        List <OrderDTO> ordersDTO = new ArrayList<>();
        for (Order o : ordersDB){
            ordersDTO.add(OrderDTOMapper.orderToDTO(o));
        }
        return ResponseEntity.ok().body(ordersDTO);
    }
}
