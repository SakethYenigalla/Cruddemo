package com.example.cruddemo.config;

import com.example.cruddemo.service.HomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cofig {

    @Bean
    public HomeService homeService() {
        return new HomeService("Saketh");
    }

    @Bean
    public HomeService homeService1() {
        return new HomeService();
    }
}
