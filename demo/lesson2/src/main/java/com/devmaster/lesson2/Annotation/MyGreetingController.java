package com.devmaster.lesson2.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyGreetingController {

    private final MyGreetingService myGreetingService;

    @Autowired
    public MyGreetingController(MyGreetingService greetingService) {
        this.myGreetingService = greetingService;
    }

    @GetMapping("/my-greet")
    public String greet() {
        return myGreetingService.greet();
    }
}
