package com.example.labguide7.service;


import com.example.labguide7.entity.Product;
import com.example.labguide7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Đọc toàn bộ dữ liệu bảng Product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Thêm mới hoặc cập nhật Product
    public Product saveProduct(Product product) {
        System.out.println(product);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
