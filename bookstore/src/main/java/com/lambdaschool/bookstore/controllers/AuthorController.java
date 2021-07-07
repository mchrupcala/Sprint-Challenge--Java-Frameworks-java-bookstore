package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.services.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //authors/authors
    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllBooksPageable(@PageableDefault(page=0, size=2)Pageable pageable) {
        ArrayList<Author> myAuthors = authorService.findAllPageable(pageable);
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }

}
