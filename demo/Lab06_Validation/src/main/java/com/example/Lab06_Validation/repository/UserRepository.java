package com.example.Lab06_Validation.repository;

import com.example.Lab06_Validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Kiểm tra userName trùng
    boolean existsByUserName(String username);

}
