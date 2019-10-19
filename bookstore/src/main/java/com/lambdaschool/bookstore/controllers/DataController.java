package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private BookService bookService;


    //GET THIS ENDPOINT WORKING BY TOMORROW MORNING
    //POST
    //books/{id}
    @PutMapping(value = "/books/{bookid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateBook(
            @RequestBody
            Book book,
            @PathVariable
                    long bookid) {
        book = bookService.update(book, bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //POST
    //books/{bookid}/authors/{authorid}
    @PostMapping("/books/{bookid}/authors/{authorid}")
    public ResponseEntity<?> postBookAuthorsById(HttpServletRequest request,
                                               @PathVariable
                                                       long bookid,
                                               @PathVariable
                                                       long authorid)
    {
//        logger.trace(request.getMethod()
//                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        bookService.addBookAuthor(bookid,
                authorid);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //DELETE
    //books/{id}

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookById(HttpServletRequest request,
                                            @PathVariable
                                                    long id)
    {
//        logger.trace(request.getMethod()
//                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
