import com.example.infrastructure.Application;
import com.example.infrastructure.entities.*;
import com.example.infrastructure.mappers.ItemDTOMapper;
import com.example.infrastructure.models.ItemDTO;
import com.example.infrastructure.repositories.CustomersRepo;
import com.example.infrastructure.repositories.ItemsRepo;
import com.example.infrastructure.repositories.OrderItemRepo;
import com.example.infrastructure.repositories.OrdersRepo;
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
@Sql(scripts={"/scripts-for-tests/items/drop_table.sql", "/scripts-for-tests/items/create_table.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ItemControllerTest {
    @Autowired
    private ItemsRepo items;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldReturnItemDTO() throws Exception{
        //given
        Item i = new Item("Test");
        items.save(i);
        ItemDTO dto = ItemDTOMapper.itemToDTO(i);
        ObjectWriter ow = new ObjectMapper().writer();
        String expectedResponseBody = ow.writeValueAsString(dto);

        //when
        MvcResult mvcResult = mockMvc.perform(get("http://localhost:8080/items/1")).andDo(print())
                .andExpect(status().isOk()).andReturn();
        //then
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(expectedResponseBody, actualResponseBody);
    }
    @Test
    public void shouldReturnDeleteConfirmation() throws Exception{
        Item i = new Item("Test");
        items.save(i);
        this.mockMvc.perform(delete("http://localhost:8080/items/1")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Item deleted")));
    }
    @Test
    public void shouldReturnNotFound() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/items/3")).andDo(print()).andExpect(status().isNotFound());
    }
    @Test
    public void shouldReturnConfirmationMessage() throws Exception {
        Item i = new Item("Test");
        ItemDTO object = ItemDTOMapper.itemToDTO(i);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(object);
        this.mockMvc.perform(post("/items").contentType("application/json;charset=UTF-8").content(json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Item added")));
    }
    @Test
    @Sql(scripts={"/scripts-for-tests/drop_all_tables.sql",
            "/scripts-for-tests/create_all_tables.sql",
            "/scripts-for-tests/insert_data.sql"
            })
    public void shouldReturnDTOList() throws Exception{
        this.mockMvc.perform(get("/itemsForOrder/1")).andDo(print()).andExpect(status().isOk());
    }
}
