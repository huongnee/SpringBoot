package com.example.Labguide8.service;


import com.example.Labguide8.entity.Book;
import com.example.Labguide8.repository.BookRepository;
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

    // Lưu thông tin sách
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
