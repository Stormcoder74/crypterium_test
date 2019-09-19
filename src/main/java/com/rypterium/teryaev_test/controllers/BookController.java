package com.rypterium.teryaev_test.controllers;

import com.rypterium.teryaev_test.entities.Book;
import com.rypterium.teryaev_test.services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public void add(@RequestBody Book book){
        bookService.add(book);
    }

    @GetMapping("{title}")
    public Book get(@PathVariable String title){
        return bookService.get(title);
    }

    @PostMapping("/update")
    public void update(@RequestBody Book book){
        bookService.update(book);
    }

    @PostMapping("/remove")
    public void remove(@RequestBody Book book){
        bookService.remove(book);
    }
}
