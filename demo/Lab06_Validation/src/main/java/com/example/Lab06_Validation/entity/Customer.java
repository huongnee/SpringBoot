package com.example.Lab06_Validation.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tài khoản không được để trống")
    @Size(min = 3, message = "Tài khoản phải ít nhất 3 ký tự")
    @Column(unique = true, nullable = false) // Tên tài khoản phải duy nhất
    private String userName;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải ít nhất 6 ký tự")
    private String password;

    @NotBlank(message = "Họ và tên không được để trống")
    @Size(min = 3, message = "Họ và tên phải ít nhất 3 ký tự")
    private String fullname;

    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|net|org)$",
            message = "Email phải có đuôi .com, .net hoặc .org")
    private String email;

    @Pattern(
            regexp = "\\+?[0-9]{10,15}$",
            message = "Điện thoại phải chứa ký tự số có độ dài trong khoảng 10 - 15"
    )
    private String phone;

    @NotBlank(message = "Họ và tên không được để trống")
    private String address;

    @NotBlank(message = "Họ và tên không được để trống")
    private String birthday;

    private Boolean isActive;

}
