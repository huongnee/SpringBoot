package com.devmaster.lesson2.Annotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appName() {
        return "<h1>VIỆN CÔNG NGHỆ DEVMASTER</h1><h2>Spring Boot Application</h2>";
    }
}
