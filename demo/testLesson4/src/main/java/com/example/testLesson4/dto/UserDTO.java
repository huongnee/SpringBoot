package com.example.testLesson4.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class UserDTO {
    @NotNull(message = "Name không được để null")
    @NotBlank(message = "Name không được để trống")
    @NotEmpty(message = "Name không được rỗng")
    @Size(min = 2, max = 50, message = "Name có độ dài trong khoảng 2 đến 50 ký tự")
    private String name;

    //    @NotNull(message = "Email không null")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Age không null")
    @Min(value = 18, message = "Age tối thiểu 18 tuổi")
    private int age;

}