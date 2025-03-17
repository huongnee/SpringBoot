package com.example.Lab06_Validation.repository;

import com.example.Lab06_Validation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //    Kiểm tra userName trùng
    boolean existsByUserName(String username);
}
