package com.example.employeeservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    //coming from application.properties
//    @Value(("${addressservice.base.url}"))
//    String addressBaseUrl;
//    @Bean
//    public WebClient webClient(){
//        return WebClient.builder().baseUrl(addressBaseUrl).build();
//    }
}
