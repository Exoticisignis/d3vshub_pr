import com.example.infrastructure.Application;
import com.example.infrastructure.models.CustomerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldReturnNotFound() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/customers/3")).andDo(print()).andExpect(status().isNotFound());
    }
    @Test
    @Sql(scripts={"/scripts-for-tests/delete_customers_data.sql"})
    public void shouldReturnConfirmationMessage() throws Exception {
        CustomerDTO object = new CustomerDTO();
        object.setName("Name");
        object.setSurname("Surname");
        object.setPhone("Phone");
        object.setSalt("salt");
        object.setPassword("password");
        object.setLogin("login");
        object.setAddress("address");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(object);
        //this.mockMvc.perform(post("/customers").contentType("application/json;charset=UTF-8").content(json)).andDo(print()).andExpect(status().isBadRequest())
                //.andExpect(content().string(containsString("Customer with this email already exists")));
        this.mockMvc.perform(post("/customers").contentType("application/json;charset=UTF-8").content(json)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Customer added")));
    }
}
