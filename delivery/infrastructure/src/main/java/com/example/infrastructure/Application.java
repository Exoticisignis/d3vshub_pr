package com.example.infrastructure;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

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
