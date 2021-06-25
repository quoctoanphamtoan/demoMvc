package com.quoctoanphamtoan.demomvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class ViewConfig {
    @Bean
    public RestTemplate getView(){
        return new RestTemplate();
    }
}
