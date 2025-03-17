package com.example.labguide7.controller;



import com.example.labguide7.entity.Category;
import com.example.labguide7.entity.Product;
import com.example.labguide7.service.CategoryService;
import com.example.labguide7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product/product-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Product product = new Product();
        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product/product-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id).orElse(new Product());
        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product/product-form";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
