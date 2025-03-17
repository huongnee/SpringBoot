package com.example.Lab06_Validation.service;


import com.example.Lab06_Validation.entity.User;
import com.example.Lab06_Validation.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

/**
 * Service xử lý logic nghiệp vụ liên quan đến User.
 */
@Service
public class UserService {

    //tạo Inject UserRepository để thao tác với cơ sở dữ liệu
    @Autowired
    private UserRepository userRepository;

    /**
     * Lấy danh sách tất cả người dùng.
     *
     * @return Danh sách người dùng (List<User>)
     */
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Tìm người dùng theo ID.
     *
     * @param id ID của người dùng cần tìm.
     * @return Optional chứa thông tin người dùng nếu tìm thấy, hoặc Optional.empty() nếu không tìm thấy.
     */
    @Transactional
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Lưu hoặc cập nhật thông tin người dùng.
     *
     * @param user Đối tượng User cần lưu hoặc cập nhật.
     * @return Đối tượng User sau khi được lưu hoặc cập nhật.
     */
//    @Transactiona thực hiện khi tất cả các việc đều đc hoàn thành rồi mới ghi nhận
    @Transactional
    public User saveUser(User user) {
        // Nếu ID của user là null, thực hiện thêm mới
        if (user.getId() == null) {
            return userRepository.save(user);
        }

        // Nếu ID không null, thực hiện cập nhật thông tin người dùng
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() ->
                new IllegalArgumentException("Không tìm thấy người dùng với ID: " + user.getId())
        );

        existingUser.setFullName(user.getFullName());
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setAddress(user.getAddress());
        existingUser.setIsActive(user.getIsActive());

        return userRepository.save(existingUser);
    }

    /**
     * Xóa người dùng theo ID.
     *
     * @param id ID của người dùng cần xóa.
     */
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
//   tạo dùng trung gian hoặc dùng trựng tiếp từ repository hay không tuy
    public Boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }
}
