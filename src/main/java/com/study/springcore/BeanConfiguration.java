package com.study.springcore;

import com.study.springcore.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration//스프링이 처음 기동될 때 이 곳을 읽음
public class BeanConfiguration {

    /*
    @Bean
    public ProductRepository productRepository() {
        String dbUrl = "jdbc:h2:mem:springcoredb";
        String dbId = "sa";
        String dbPassword = "";

        return new ProductRepository(dbUrl, dbId, dbPassword);
    }

     */
}