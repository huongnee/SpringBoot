package com.example.Labguide05.controller;

import com.example.Labguide05.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private List<User> users = new ArrayList<>();

    public AdminController() {
        // Thêm dữ liệu mẫu
        users.add(new User(1, "John Doe", "john.doe@example.com"));
        users.add(new User(2, "Jane Smith", "jane.smith@example.com"));
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/users/add")
    public String addUserForm() {
        return "admin/add_user";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        int newId = users.size() + 1;
        users.add(new User(newId, name, email));
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model) {
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        model.addAttribute("user", user);
        return "admin/edit_user";
    }

    @PostMapping("/users/edit")
    public String editUser(@RequestParam int id, @RequestParam String name, @RequestParam String email) {
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        users.removeIf(u -> u.getId() == id);
        return "redirect:/admin/users";
    }
}