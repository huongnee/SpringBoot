package com.example.Lab09.service;


import com.example.Lab09.entity.Book;
import com.example.Lab09.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Lấy danh sách tất cả các sách
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Lấy thông tin sách theo ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Xóa sách theo ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
