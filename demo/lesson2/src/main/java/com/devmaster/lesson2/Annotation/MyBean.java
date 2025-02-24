package com.devmaster.lesson2.Annotation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MyBean {

    private final AppConfig appConfig;

    @Autowired
    public MyBean(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/my-bean")
    public String myBean() {
        return appConfig.appName();
    }
}