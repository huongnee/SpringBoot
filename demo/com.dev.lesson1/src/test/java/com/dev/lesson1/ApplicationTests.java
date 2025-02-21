package com.dev.lesson1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hello World");
	}

}
