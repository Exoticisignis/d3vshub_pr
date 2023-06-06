import com.example.infrastructure.Application;
import com.example.infrastructure.entities.*;
import com.example.infrastructure.mappers.OrderDTOMapper;
import com.example.infrastructure.models.OrderDTO;
import com.example.infrastructure.repositories.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
@Sql(scripts={"/scripts-for-tests/drop_all_tables.sql",
        "/scripts-for-tests/create_all_tables.sql",
        "/scripts-for-tests/insert_data.sql"
}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrdersRepo orders;
    @Autowired
    private CustomersRepo customers;
    @Autowired
    private ItemsRepo items;

    @Test
    @Transactional
    public void shouldReturnOrderDTO() throws Exception{
        //given
        int index = orders.getNumberOfRows();
        Order o= orders.getReferenceById((long) index);
        OrderDTO dto = OrderDTOMapper.orderToDTO(o);
        ObjectWriter ow = new ObjectMapper().writer();
        String expectedResponseBody = ow.writeValueAsString(dto);
        String url = "/orders/";
        url+= Integer.toString(index);
        //when
        MvcResult mvcResult = mockMvc.perform(get(url)).andDo(print())
                .andExpect(status().isOk()).andReturn();
        //then
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(expectedResponseBody, actualResponseBody);
    }
    @Test
    public void shouldReturnDeleteConfirmation() throws Exception{
        int index = orders.getNumberOfRows();
        String url = "/orders/" ;
        url+= Integer.toString(index);
        this.mockMvc.perform(delete(url)).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Order deleted")));
    }
    @Test
    public void shouldReturnNotFound() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/orders/99999")).andDo(print())
                .andExpect(status().isNotFound());
    }
    @Test
    @Transactional
    public void shouldReturnConfirmationMessage() throws Exception {
        OrderDTO dto = new OrderDTO();
        dto.setAddress("testAddress");
        dto.setTotalPrice(999.99);
        int cIndex = customers.getNumberOfRows();
        dto.setCustomer((long)cIndex);
        dto.setOrderDate("2022-06-06 12:00:00");
        List<String> list = new ArrayList<>();
        list.add(items.getReferenceById(1L).getItemName());
        list.add(items.getReferenceById(2L).getItemName());
        dto.setOrderItems(list);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dto);
        this.mockMvc.perform(post("/orders").contentType("application/json;charset=UTF-8").content(json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Order added")));
    }
    @Test
    public void shouldReturnOrderForFirstCustomer() throws Exception {
        int index = 1;
        String url = "/ordersForCustomer/" + index;
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void shouldReturnOrderForItem() throws Exception {
        int index = 1;
        String url = "/ordersForItem/" + index;
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
    }
}
