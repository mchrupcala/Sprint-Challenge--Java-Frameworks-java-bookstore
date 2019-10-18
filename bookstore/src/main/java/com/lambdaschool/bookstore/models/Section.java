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
@Table(name = "section")
public class Section extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false, unique = true)
    private String name;


    @OneToMany(mappedBy = "section",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("section")
    private List<Book> books = new ArrayList<>();

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return name;
    }

    public void setSectionname(String sectionname) {
        this.name = sectionname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
