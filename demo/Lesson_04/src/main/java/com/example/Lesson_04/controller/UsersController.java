package com.example.Lesson_04.controller;



import com.example.Lesson_04.dto.UsersDTO;
import com.example.Lesson_04.entity.Users;
import com.example.Lesson_04.service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/user-list")
    public List<Users> getAllUsers() {
        return usersService.findAll();
    }

    @PostMapping("/user-add")
    public ResponseEntity<String> addUser(@Valid @RequestBody UsersDTO user) {
        usersService.create(user);
        return ResponseEntity.ok("User created successfully");
    }
}
