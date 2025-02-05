package com.example.CRUDApplication.repo;

import com.example.CRUDApplication.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query("Delete from Book b where b.author = :author")
    void deleteBookByAuthor(String author);
}
