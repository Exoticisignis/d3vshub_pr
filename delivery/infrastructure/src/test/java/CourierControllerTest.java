import com.example.infrastructure.Application;
import com.example.infrastructure.entities.Courier;
import com.example.infrastructure.mappers.CourierDTOMapper;
import com.example.infrastructure.models.CourierDTO;
import com.example.infrastructure.repositories.CouriersRepo;
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

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
@Sql(scripts={"/scripts-for-tests/couriers/drop_table.sql", "/scripts-for-tests/couriers/create_table.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class CourierControllerTest {
    @Autowired
    private CouriersRepo couriers;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldReturnCustomerDTO() throws Exception{
        //given
        Courier c = new Courier("Test");
        couriers.save(c);
        CourierDTO dto = CourierDTOMapper.courierToDTO(c);
        ObjectWriter ow = new ObjectMapper().writer();
        String expectedResponseBody = ow.writeValueAsString(dto);

        //when
        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/couriers/1")).andDo(print())
                .andExpect(status().isOk()).andReturn();
        //then
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(expectedResponseBody, actualResponseBody);
    }
    @Test
    public void shouldReturnDeleteConfirmation() throws Exception{
        Courier c = new Courier("Test");
        couriers.save(c);
        this.mockMvc.perform(delete("http://localhost:8080/couriers/1")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Courier deleted")));
    }
    @Test
    public void shouldReturnNotFound() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/couriers/3")).andDo(print()).andExpect(status().isNotFound());
    }
    @Test
    public void shouldReturnConfirmationMessage() throws Exception {
        CourierDTO object = new CourierDTO();
        object.setName("Name");
        object.setSurname("Surname");
        object.setPhone("Phone");
        object.setSalt("salt");
        object.setPassword("password");
        object.setLogin("login");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(object);
        this.mockMvc.perform(post("/couriers").contentType("application/json;charset=UTF-8").content(json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Courier added")));
    }
    @Test
    public void shouldReturnBadRequest() throws Exception{
        //given
        Courier c = new Courier("test");
        c.setLogin("duplicate");
        couriers.save(c);
        CourierDTO object = new CourierDTO();
        object.setName("Name");
        object.setSurname("Surname");
        object.setPhone("Phone");
        object.setSalt("salt");
        object.setPassword("password");
        object.setLogin("duplicate");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(object);
        //when & then
        this.mockMvc.perform(post("/couriers").contentType("application/json;charset=UTF-8").content(json))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Courier with this login already exists")));
    }
}
