package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface AuthorService {

    ArrayList<Author> findAll();

    ArrayList<Author> findAllPageable(Pageable pageable);

}
