package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //books/books
    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooksPageable(@PageableDefault(page=0, size=2) Pageable pageable) {
        ArrayList<Book> myBooks = bookService.findAllPageable(pageable);
        return new ResponseEntity<>(myBooks, HttpStatus.OK);
    }
}
