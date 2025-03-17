package com.example.labguide7.service;

import com.example.labguide7.entity.Category;
import com.example.labguide7.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Lấy danh sách tất cả các Category
    public List<Category> getAllCategories() {
        System.out.println(categoryRepository.findAll());
        return categoryRepository.findAll();
    }

    // Lấy Category theo ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
