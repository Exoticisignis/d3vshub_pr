package com.example.infrastructure;


import com.example.infrastructure.dbconf.DataSourceConfig;
import com.example.infrastructure.entities.Customer;
import com.example.infrastructure.repositories.CustomersRepo;
import com.example.infrastructure.repositories.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootApplication
public class Application {
    @Autowired

    public static void main(String[] args) {
        DataSourceConfig dsc = new DataSourceConfig();
        DataSource dataSource = dsc.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SpringApplication.run(Application.class, args);
        int result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM ITEMS", Integer.class);
        System.out.println(result);
    }/*
    @Bean
    public CommandLineRunner run(ItemsRepo itemsRepo) throws Exception {
        return (String[] args) -> {
            //Customer c1 = new Customer("John", "john@domain.com");
            //customersRepo.save(c1);
            itemsRepo.findAll().forEach(i -> System.out.println(i));
        };
    }*/

}
