package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    @Query(value = "SELECT COUNT(*) as count FROM wrote WHERE bookid = :bookid AND authorid = :authorid",
            nativeQuery = true)
    JustTheCount checkUserRolesCombo(long bookid,
                                     long authorid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote(bookid, authorid) VALUES (:bookid, :authorid)",
            nativeQuery = true)
    void insertUserRoles(long bookid,
                         long authorid);
}
