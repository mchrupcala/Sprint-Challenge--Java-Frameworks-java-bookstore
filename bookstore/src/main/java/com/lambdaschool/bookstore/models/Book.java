package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.bookstore.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "book")
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique  = true)
    private String ISBN;

    //year the book was published (copyright date)
    private int copy;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("sections")
    private Section section;

    public Book() {

    }

    public Book(String title, String ISBN, int copy, Section section) {
        this.title = title;
        this.ISBN = ISBN;
        this.copy = copy;
        this.section = section;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return title;
    }

    public void setBooktitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
