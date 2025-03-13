package com.example.Lesson6.controller;

import com.example.Lesson6.dto.CustomerDTO;
import com.example.Lesson6.entity.Customer;
import com.example.Lesson6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers") // Thay đổi endpoint từ "/students" -> "/customers"
public class CustomerController {

    private final CustomerService customerService; // Đổi từ StudentService -> CustomerService

    @Autowired
    public CustomerController(CustomerService customerService) { // Sửa constructor
        this.customerService = customerService;
    }

    // Hiển thị danh sách khách hàng
    @GetMapping
    public String getCustomers(Model model) { // Đổi tên phương thức
        model.addAttribute("customers", customerService.findAll()); // Đổi attribute "students" -> "customers"
        return "customers/customer-list"; // Đổi đường dẫn view
    }

    // Form thêm mới khách hàng
    @GetMapping("/add-new")
    public String addNewCustomer(Model model) { // Đổi tên phương thức
        model.addAttribute("customer", new Customer()); // Đổi attribute "student" -> "customer"
        return "customers/customer-add"; // Đổi đường dẫn view
    }

    // Form chỉnh sửa khách hàng
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        CustomerDTO customer = customerService.findById(id) // Đổi từ studentService -> customerService
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id)); // Thay đổi thông báo lỗi
        model.addAttribute("customer", customer); // Đổi attribute "student" -> "customer"
        return "customers/customer-edit"; // Đổi đường dẫn view
    }

    // Lưu khách hàng mới
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") CustomerDTO customer) { // Đổi tham số
        customerService.save(customer);
        return "redirect:/customers"; // Đổi redirect endpoint
    }

    // Cập nhật khách hàng
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id,
                                 @ModelAttribute("customer") CustomerDTO customer) { // Đổi tham số
        customerService.updateCustomerById(id, customer);
        return "redirect:/customers"; // Đổi redirect endpoint
    }

    // Xóa khách hàng
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        if (customerService.findById(id).isPresent()) { // Đổi từ studentService -> customerService
            customerService.deleteCustomer(id); // Đổi phương thức xóa
            return "redirect:/customers"; // Đổi redirect endpoint
        } else {
            throw new IllegalArgumentException("Customer with ID " + id + " does not exist."); // Thay đổi thông báo lỗi
        }
    }
}
