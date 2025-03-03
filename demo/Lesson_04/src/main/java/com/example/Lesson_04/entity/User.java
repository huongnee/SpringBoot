package com.example.Lesson_04.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor  // 👉 Thêm dòng này để tạo constructor không tham số
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String username;
    String password;
    String fullName;
    LocalDate birthDay;
    String email;
    String phone;
    int age;
    Boolean status;
}
