package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.exceptions.ResourceFoundException;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookrepos;

    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public ArrayList<Book> findAll() {
        ArrayList<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    };

    @Override
    public ArrayList<Book> findAllPageable(Pageable pageable) {
        ArrayList<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    };


    @Transactional
    @Override
    public Book save(Book book) {
        Book newBook = new Book();

        newBook.setISBN(book.getISBN());
        newBook.setCopy(book.getCopy());
        newBook.setBooktitle(book.getBooktitle());
//        newBook.setAuthors(book.getAuthors());
//        newBook.setSection(book.getSection());

        return bookrepos.save(newBook);
    }

    @Transactional
    @Override
    public Book update(Book book, long bookid) {


        Book currentBook = bookrepos.findById(bookid);
//                .orElseThrow(() -> new EntityNotFoundException(Long.toString(bookid)));

        if (currentBook != null) {
            if (book.getBooktitle() != null) {
                currentBook.setBooktitle(book.getBooktitle());
            }

            if (book.getCopy() != 0) {
                currentBook.setCopy(book.getCopy());
            }

            if (book.getISBN() != null) {
                currentBook.setISBN(book.getISBN());
            }

            return bookrepos.save(currentBook);
        } else {
            {
                throw new EntityNotFoundException("Book was not found.");
            }
        }
    }

    @Transactional
    @Override
    public void addBookAuthor(long bookid,
                            long authorid)
    {
        bookrepos.findById(bookid);
//                .orElseThrow(() -> new ResourceNotFoundException("Book id " + bookid + " not found!"));
        authorrepos.findById(authorid)
                .orElseThrow(() -> new ResourceNotFoundException("Author id " + authorid + " not found!"));

        if (authorrepos.checkUserRolesCombo(bookid,
                authorid)
                .getCount() <= 0)
        {
            authorrepos.insertUserRoles(bookid,
                    authorid);
        } else
        {
            throw new ResourceFoundException("Book and Author Combination Already Exists");
        }
    }

    //works if there's no book/author combo
    @Transactional
    @Override
    public void delete(long id)
    {
        bookrepos.findById(id);
//                .orElseThrow(() -> new ResourceNotFoundException("Book id " + id + " not found!"));

//        bookrepos.deleteBookAuthors(id, authorid )
        bookrepos.deleteById(id);
    }

}
