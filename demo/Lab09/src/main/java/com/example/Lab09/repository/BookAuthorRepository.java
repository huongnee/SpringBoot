package com.example.Lab09.repository;

import com.example.Lab09.entity.Book;
import com.example.Lab09.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
    void deleteByBook(Book book);
}