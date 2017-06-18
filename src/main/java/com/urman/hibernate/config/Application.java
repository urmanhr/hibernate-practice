package com.urman.hibernate.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.urman.hibernate.*"})
@EntityScan(basePackages = "com.urman.hibernate.pojo")
public class Application{

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}