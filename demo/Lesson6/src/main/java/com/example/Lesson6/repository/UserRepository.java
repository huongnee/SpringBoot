package com.example.Lesson6.repository;

import com.example.Lesson6.entity.Student;
import com.example.Lesson6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
