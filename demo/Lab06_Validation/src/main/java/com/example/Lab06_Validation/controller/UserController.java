package com.example.Lab06_Validation.controller;


import com.example.Lab06_Validation.entity.User;
import com.example.Lab06_Validation.repository.UserRepository;
import com.example.Lab06_Validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller xử lý các yêu cầu liên quan đến User.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    // Inject UserService để xử lý logic nghiệp vụ
    @Autowired
    private UserService userService;

    // Inject UserRepository để kiểm tra dữ liệu
    @Autowired
    private UserRepository userRepository;

    /**
     * Hiển thị danh sách người dùng.
     *
     * @param model Đối tượng Model để truyền dữ liệu sang giao diện.
     * @return Tên view hiển thị danh sách người dùng.
     */
//    List<User> này là trả về 1 chuỗi json còn String trả về bình thường
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers(); // Lấy danh sách người dùng từ Service
        model.addAttribute("users", users);          // Truyền danh sách người dùng sang view
        return "user/list";                          // Trả về tên view
    }

    /**
     * Hiển thị form tạo mới người dùng.
     *
     * @param model Đối tượng Model để truyền dữ liệu sang giao diện.
     * @return Tên view hiển thị form tạo mới.
     */
    @GetMapping("/new")
    public String createUserForm(Model model) {
        User user = new User();                      // Tạo đối tượng User mới
        user.setIsActive(true);                      // Mặc định trạng thái hoạt động là true
        model.addAttribute("user", user);            // Truyền đối tượng User sang view
        return "user/form";                          // Trả về tên view form
    }

    /**
     * Lưu thông tin người dùng (thêm mới hoặc cập nhật).
     *
     * @param user   Đối tượng User được gửi từ form.
     * @param result Kết quả kiểm tra hợp lệ của dữ liệu.
     * @param model  Đối tượng Model để truyền dữ liệu sang giao diện nếu có lỗi.
     * @return Tên view hoặc redirect sau khi lưu.
     */
    @PostMapping("/save")
    public String saveUser(
            @Validated @ModelAttribute("user") User user,
            BindingResult result,
            Model model) {

        // Kiểm tra xem username đã tồn tại chưa (chỉ kiểm tra khi thêm mới)
        if (userRepository.existsByUserName(user.getUserName()) && user.getId() == null) {
            result.rejectValue(
                    "userName",
                    "error.user",
                    "UserName đã tồn tại, vui lòng chọn tên khác."
            );
            return "user/form";                      // Quay lại form nếu có lỗi
        }

        // Kiểm tra các lỗi khác từ dữ liệu nhập vào
        if (result.hasErrors()) {
            return "user/form";                      // Quay lại form nếu có lỗi
        }

        userService.saveUser(user);                  // Lưu thông tin người dùng qua Service
        return "redirect:/users";                    // Redirect về danh sách người dùng sau khi lưu thành công
    }

    /**
     * Hiển thị form chỉnh sửa thông tin người dùng.
     *
     * @param id    ID của người dùng cần chỉnh sửa.
     * @param model Đối tượng Model để truyền dữ liệu sang giao diện.
     * @return Tên view hiển thị form chỉnh sửa.
     */
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid user ID: " + id)); // Tìm người dùng theo ID hoặc ném ngoại lệ nếu không tìm thấy

        model.addAttribute("user", user);            // Truyền đối tượng User sang view
        return "user/form";                          // Trả về tên view form chỉnh sửa
    }

    /**
     * Xóa người dùng theo ID.
     *
     * @param id ID của người dùng cần xóa.
     * @return Redirect về danh sách người dùng sau khi xóa thành công.
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);                  // Xóa người dùng qua Service
        return "redirect:/users";                    // Redirect về danh sách người dùng sau khi xóa thành công
    }
}
