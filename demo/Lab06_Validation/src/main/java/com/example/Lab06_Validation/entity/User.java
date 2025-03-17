package com.example.Lab06_Validation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * param
 * Entity đại diện cho bảng "users" trong cơ sở dữ liệu.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // ID của người dùng (khóa chính, tự động tăng)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Họ và tên người dùng (không được để trống, tối thiểu 3 ký tự)
    @NotBlank(message = "Họ và tên không được để trống")
    @Size(min = 3, message = "Họ và tên phải ít nhất 3 ký tự")
    private String fullName;

    // Tên tài khoản (không được để trống, tối thiểu 3 ký tự)
    @NotBlank(message = "Tài khoản không được để trống")
    @Size(min = 3, message = "Tài khoản phải ít nhất 3 ký tự")
    @Column(unique = true, nullable = false) // Tên tài khoản phải duy nhất
    private String userName;

    // Mật khẩu (không được để trống, tối thiểu 6 ký tự)
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải ít nhất 6 ký tự")
    private String password;

    // Email (phải đúng định dạng email)
    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|net|org)$",
            message = "Email phải có đuôi .com, .net hoặc .org")
    private String email;


    // Số điện thoại (phải theo định dạng regex và có độ dài từ 10-15 ký tự)
    @Pattern(
            regexp = "\\+?[0-9]{10,15}$",
            message = "Điện thoại phải chứa ký tự số có độ dài trong khoảng 10 - 15"
    )
    private String phone;

    // Địa chỉ của người dùng
    private String address;

    // Trạng thái hoạt động của người dùng (true/false)
    private Boolean isActive;
}
