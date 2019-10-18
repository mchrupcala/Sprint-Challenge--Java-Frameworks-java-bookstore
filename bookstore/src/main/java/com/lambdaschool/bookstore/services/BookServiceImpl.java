package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookrepos;

    @Override
    public ArrayList<Book> findAll() {
        ArrayList<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    };

    @Override
    public Book update(Book book, long id) {
        Book currentBook = bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
//title, copy, isbn
        if (book.getBooktitle() != null)
        {
            currentBook.setBooktitle(book.getBooktitle());
        }

        if (book.getCopy() != 0)
        {
            currentBook.setCopy(book.getCopy());
        }

        if (book.getISBN() != null)
        {
            currentBook.setISBN(book.getISBN());
        }

        return bookrepos.save(currentBook);
    }

    @Transactional
    @Override
    public Book save(Book book)
    {
        Book newBook = new Book();

        newBook.setISBN(newBook.getISBN());
        newBook.setCopy(newBook.getCopy());
        newBook.setBooktitle(newBook.getBooktitle());
        newBook.setAuthors(newBook.getAuthors());
        newBook.setSection(newBook.getSection());

        return bookrepos.save(newBook);
    }

}
