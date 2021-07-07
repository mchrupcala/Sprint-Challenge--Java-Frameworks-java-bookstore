package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findById(long bookid);
}
