package com.devmaster.lesson2.Spring_IoC;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        return "<h2>Devmaster [Spring Boot!] Xin chào,</h2>" +
                "<h1 style='color:red; text-align:center'>" + name + "</h1>";
    }
}
