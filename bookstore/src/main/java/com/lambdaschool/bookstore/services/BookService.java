package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> findAll();
}
