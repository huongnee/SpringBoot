package com.example.Lab06_Validation.controller;
import com.example.Lab06_Validation.entity.Customer;
import com.example.Lab06_Validation.entity.User;
import com.example.Lab06_Validation.repository.CustomerRepository;
import com.example.Lab06_Validation.repository.UserRepository;
import com.example.Lab06_Validation.service.CustomerService;
import com.example.Lab06_Validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;


//    List<User> này là trả về 1 chuỗi json còn String trả về bình thường
    @GetMapping
    public String listCustomer(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer/list";
    }


    @GetMapping("/new")
    public String createCustomerForm(Model model) {
        Customer customer = new Customer();
        customer.setIsActive(true);
        model.addAttribute("customer", customer);
        return "customer/form";
    }
}
