package com.example.Lesson6.repository;

import com.example.Lesson6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findById(Long id); // Sử dụng Long thay vì Integer
    void deleteById(Long id); // Sử dụng Long thay vì Integer
}
