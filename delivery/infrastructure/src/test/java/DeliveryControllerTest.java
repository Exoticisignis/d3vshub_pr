import com.example.infrastructure.Application;
import com.example.infrastructure.entities.*;
import com.example.infrastructure.mappers.DeliveryDTOMapper;
import com.example.infrastructure.models.DeliveryDTO;
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


import java.sql.Timestamp;
import java.time.LocalDateTime;

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
public class DeliveryControllerTest {
    @Autowired
    private DeliveriesRepo deliveries;


    @Autowired
    private MockMvc mockMvc;
    @Test
    @Transactional
    public void shouldReturnDeliveryDTO() throws Exception{
        //given
        int index = deliveries.getNumberOfRows();
        Delivery d= deliveries.getReferenceById((long) index);
        DeliveryDTO dto = DeliveryDTOMapper.deliveryToDTO(d);
        ObjectWriter ow = new ObjectMapper().writer();
        String expectedResponseBody = ow.writeValueAsString(dto);
        String url = "/deliveries/";
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
        int index = 1;
        String url = "/deliveries/";
        url+= Integer.toString(index);
        this.mockMvc.perform(delete(url)).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Delivery deleted")));
    }
    @Test
    public void shouldReturnNotFound() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/deliveries/99999")).andDo(print())
                .andExpect(status().isNotFound());
    }
    @Test
    public void shouldReturnConfirmationMessage() throws Exception {
        Long o = 1L;
        Long c = 1L;
        DeliveryDTO dto = new DeliveryDTO();
        dto.setCourier(c);
        dto.setOrder(o);
        dto.setDeliveryDate(Timestamp.valueOf(LocalDateTime.now()).toString());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dto);
        this.mockMvc.perform(post("/deliveries").contentType("application/json;charset=UTF-8").content(json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Delivery added")));
    }
}
