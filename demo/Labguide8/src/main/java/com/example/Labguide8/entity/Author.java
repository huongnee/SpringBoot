package com.example.Labguide8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String description;
    private String imgUrl;
    private String email;
    private String phone;
    private String address;
    private Boolean isActive;

    // Quan hệ nhiều-nhiều với bảng Book
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();
}
