package com.example.Labguide05.controller;


import com.example.Labguide05.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", List.of(
                new User(1, "John Doe", "john.doe@example.com"),
                new User(2, "Jane Smith", "jane.smith@example.com")
        ));
        return "admin/users";
    }

    @GetMapping("/users/add")
    public String addUser() {
        return "admin/add_user";
    }

    @GetMapping("/users/edit")
    public String editUser() {
        return "admin/edit_user";
    }
}