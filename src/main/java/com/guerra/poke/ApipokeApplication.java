package com.guerra.poke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApipokeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApipokeApplication.class, args);
    }

}
