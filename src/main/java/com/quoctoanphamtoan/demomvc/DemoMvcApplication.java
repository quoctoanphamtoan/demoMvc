package com.quoctoanphamtoan.demomvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.quoctoanphamtoan")
public class DemoMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoMvcApplication.class, args);
    }
}
