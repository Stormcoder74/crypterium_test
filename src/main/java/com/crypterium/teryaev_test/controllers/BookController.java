package com.crypterium.teryaev_test.controllers;

import com.crypterium.teryaev_test.entities.Book;
import com.crypterium.teryaev_test.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Book book){
        if (bookService.add(book)) {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{title}")
    public ResponseEntity get(@PathVariable String title){
        Book book = bookService.get(title);
        if (book == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Book book){
        if (bookService.update(book)) {
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity remove(@RequestBody Book book){
        if (bookService.remove(book)) {
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
