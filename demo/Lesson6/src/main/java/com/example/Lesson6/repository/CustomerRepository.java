package com.example.Lesson6.repository;

import com.example.Lesson6.entity.Customer;
import com.example.Lesson6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findById(Long id);
    void deleteById(Long id);
}
