package com.example.Lesson6.service;

import com.example.Lesson6.entity.User;
import com.example.Lesson6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Tạo mới người dùng
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Lấy danh sách người dùng
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Cập nhật thông tin người dùng
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Xóa người dùng theo ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
