package com.rypterium.teryaev_test.services;

import com.rypterium.teryaev_test.entities.Book;
import com.rypterium.teryaev_test.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void add(Book book){
        if (book.getId() == null) {
            bookRepository.save(book);
        }
    }

    public Book get(String title){
        Book book = bookRepository.findByTitle(title);
        return book;
    }

    public void update(Book book){
        if (book.getId() != null) {
            bookRepository.save(book);
        }
    }

    public void remove(Book book){
        bookRepository.delete(book);
    }
}
