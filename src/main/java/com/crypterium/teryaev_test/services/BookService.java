package com.crypterium.teryaev_test.services;

import com.crypterium.teryaev_test.entities.Book;
import com.crypterium.teryaev_test.repositories.BookRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean add(Book book){
        if (book.getId() == null) {
            try {
                bookRepository.save(book);
                return true;
            } catch (DataIntegrityViolationException e) {
                return false;
            }
        }
        return false;
    }

    public Book get(String title){
        return bookRepository.findByTitle(title);
    }

    public boolean update(Book book){
        Book savedBook = bookRepository.findById(book.getId()).orElse(null);
        if (savedBook != null) {
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    public boolean remove(Book book){
        Book savedBook = bookRepository.findById(book.getId()).orElse(null);
        if (savedBook != null) {
            bookRepository.delete(book);
            return true;
        }
        return false;
    }
}
