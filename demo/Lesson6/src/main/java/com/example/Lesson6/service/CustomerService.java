package com.example.Lesson6.service;


import com.example.Lesson6.dto.CustomerDTO;
import com.example.Lesson6.entity.Customer;
import com.example.Lesson6.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Lấy danh sách tất cả khách hàng
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Tìm khách hàng theo ID và chuyển sang DTO
    public Optional<CustomerDTO> findById(long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) return Optional.empty();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setFullname(customer.getFullname());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setBirthday(customer.getBirthday());
        customerDTO.setActive(customer.getActive());

        return Optional.of(customerDTO);
    }

    // Thêm mới khách hàng từ DTO
    public Boolean save(CustomerDTO customerDTO) {
        try {
            Customer customer = new Customer();
            customer.setUsername(customerDTO.getUsername());
            customer.setPassword(customerDTO.getPassword());
            customer.setFullname(customerDTO.getFullname());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhone(customerDTO.getPhone());
            customer.setAddress(customerDTO.getAddress());
            customer.setBirthday(customerDTO.getBirthday());
            customer.setActive(customerDTO.getActive());
            customerRepository.save(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Cập nhật thông tin khách hàng theo ID
    public Customer updateCustomerById(Long id, CustomerDTO updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setUsername(updatedCustomer.getUsername());
                    customer.setPassword(updatedCustomer.getPassword());
                    customer.setFullname(updatedCustomer.getFullname());
                    customer.setEmail(updatedCustomer.getEmail());
                    customer.setPhone(updatedCustomer.getPhone());
                    customer.setAddress(updatedCustomer.getAddress());
                    customer.setBirthday(updatedCustomer.getBirthday());
                    customer.setActive(updatedCustomer.getActive());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));
    }

    // Xóa khách hàng theo ID
    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
