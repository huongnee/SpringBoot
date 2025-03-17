package com.example.Lab06_Validation.service;
import com.example.Lab06_Validation.entity.Customer;
import com.example.Lab06_Validation.entity.User;
import com.example.Lab06_Validation.repository.CustomerRepository;
import com.example.Lab06_Validation.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Transactional
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }


//    @Transactiona thực hiện khi tất cả các việc đều đc hoàn thành rồi mới ghi nhận
    @Transactional
    public Customer saveCustomer(Customer customer) {
        // Nếu ID của customer là null, thực hiện thêm mới
        if (customer.getId() == null) {
            return customerRepository.save(customer);
        }

        // Nếu ID không null, thực hiện cập nhật thông tin người dùng
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElseThrow(() ->
                new IllegalArgumentException("Không tìm thấy người dùng với ID: " + customer.getId())
        );

        existingCustomer.setFullname(customer.getFullname());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setBirthday(customer.getBirthday());
        existingCustomer.setUserName(customer.getUserName());
        existingCustomer.setIsActive(customer.getIsActive());
        return customerRepository.save(existingCustomer);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    //   tạo dùng trung gian hoặc dùng trựng tiếp từ repository hay không tuy
    public Boolean existsByCustomerName(String username) {
        return customerRepository.existsByUserName(username);
    }
}
