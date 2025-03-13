package com.example.Lesson6.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;

    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;
    private String address;
    private String birthday;
    private String active;
}
