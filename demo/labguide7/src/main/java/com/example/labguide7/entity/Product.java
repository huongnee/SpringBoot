package com.example.labguide7.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "products")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String imageUrl;
    Integer quantity;
    Double price;
    String content;
    Boolean status;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    Category category;
}
