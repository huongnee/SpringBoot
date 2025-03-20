package com.example.Labguide8.service;

import com.example.Labguide8.entity.Author;
import com.example.Labguide8.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Lấy danh sách tất cả các tác giả
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Lưu thông tin tác giả
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Lấy thông tin tác giả theo ID
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    // Xóa tác giả theo ID
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    // Tìm danh sách tác giả theo danh sách ID
    public List<Author> findAllById(List<Long> ids) {
        return authorRepository.findAllById(ids);
    }
}
