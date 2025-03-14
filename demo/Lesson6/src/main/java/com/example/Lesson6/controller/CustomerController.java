package com.example.Lesson6.controller;

import com.example.Lesson6.dto.CustomerDTO;
import com.example.Lesson6.entity.Customer;
import com.example.Lesson6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/customer-list";
    }

    @GetMapping("/add-new")
    public String addNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/customer-add";
    }


    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        CustomerDTO customer = customerService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));
        model.addAttribute("customer", customer);
        return "customers/customer-edit";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") CustomerDTO customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id,
                                 @ModelAttribute("customer") CustomerDTO customer) {
        customerService.updateCustomerById(id, customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        if (customerService.findById(id).isPresent()) {
            customerService.deleteCustomer(id);
            return "redirect:/customers";
        } else {
            throw new IllegalArgumentException("Customer with ID " + id + " does not exist.");
        }
    }
}
