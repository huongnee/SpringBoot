package com.example.Lab09.controller;


import com.example.Lab09.entity.Author;
import com.example.Lab09.entity.Book;
import com.example.Lab09.entity.BookAuthor;
import com.example.Lab09.repository.BookAuthorRepository;
import com.example.Lab09.service.AuthorService;
import com.example.Lab09.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/";
    private static final String UPLOAD_PathFile = "images/products/";

    // Hiển thị toàn bộ sách
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/book-list";
    }

    // Hiển thị form thêm mới sách
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/book-form";
    }

    // Lưu thông tin sách mới
    @PostMapping("/new")
    @Transactional
    public String saveBook(
            @ModelAttribute Book book,
            @RequestParam List<Long> authorIds,
            @RequestParam(required = false) Long editorId) {

        // Lưu thông tin sách mới
        Book savedBook = bookService.saveBook(book);

        // Xử lý danh sách tác giả và chủ biên
        for (Long authorId : authorIds) {
            Author author = authorService.getAuthorById(authorId);
            boolean isEditor = (editorId != null && editorId.equals(authorId));

            BookAuthor bookAuthor = BookAuthor.builder()
                    .book(savedBook)
                    .author(author)
                    .isEditor(isEditor)
                    .build();

            bookAuthorRepository.save(bookAuthor);
        }

        return "redirect:/books";
    }





    // Hiển thị form chỉnh sửa thông tin sách
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/book-form";
    }

    // Xóa sách theo ID
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}