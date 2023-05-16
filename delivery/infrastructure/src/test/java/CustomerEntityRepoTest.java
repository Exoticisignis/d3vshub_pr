/*
import com.example.infrastructure.Application;
import com.example.infrastructure.entities.Customer;
import com.example.infrastructure.repositories.CustomersRepo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = Application.class)
public class CustomerEntityRepoTest {
    @Autowired private CustomersRepo cRepo;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Test
    public void saveCustomerTest(){
        Customer c = new Customer("test1");
        cRepo.save(c);
        Customer c1 = new Customer("test1");
        Assert.assertEquals(c1.getName(), c.getName());
    }
    @Test
    public void deleteSaveCustomers(){
        jdbcTemplate.update("DELETE FROM customers");
        Customer c;
        for(int i = 0; i < 10; i++){
            c = new Customer("test" + i);
            cRepo.save(c);
        }
        String sql = "SELECT COUNT(*) FROM customers";
        int count = jdbcTemplate.queryForObject(
                sql, Integer.class);
        Assert.assertEquals(10, count);
    }
}
*/