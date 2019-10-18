package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> findAll();

    ArrayList<Book> findAllPageable(Pageable pageable);

    Book update(Book book, long id);

    Book save(Book book);

    void addBookAuthor(long bookid, long authorid);

    void delete(long id);

//    void deleteBookAuthors(long bookid,
//                           long authorid);
}
