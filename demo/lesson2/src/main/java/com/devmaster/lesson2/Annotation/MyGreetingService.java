package com.devmaster.lesson2.Annotation;

import org.springframework.stereotype.Service;

@Service
public class MyGreetingService {
    public String greet() {
        return "<h1>Hello from MyGreetingService!</h1>";
    }
}