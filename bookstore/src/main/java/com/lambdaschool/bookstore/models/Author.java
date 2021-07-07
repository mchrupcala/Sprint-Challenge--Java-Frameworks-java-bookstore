package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.bookstore.logging.Loggable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "author")
public class Author extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lname;
    private String fname;

    @ManyToMany
    @JoinTable(name = "wrote",
            joinColumns = {@JoinColumn(name = "authorid")},
            inverseJoinColumns = {@JoinColumn(name = "bookid")})
    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(String lname, String fname) {
        this.lname = lname;
        this.fname = fname;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lname;
    }

    public void setLastname(String lname) {
        this.lname = lname;
    }

    public String getFirstname() {
        return fname;
    }

    public void setFirstname(String fname) {
        this.fname = fname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
