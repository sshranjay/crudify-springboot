package com.example.CRUDApplication.controller;

import com.example.CRUDApplication.model.Book;
import com.example.CRUDApplication.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBooks() {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRepo.findAll().forEach(bookList::add);
            if(bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookList, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> bookData = bookRepo.findById(id);
        if(bookData.isPresent()) {
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book bookObj = bookRepo.save(book);
        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookByAuthor/{author}")
    public ResponseEntity<HttpStatus> deleteBookByAuthor(@PathVariable String author) {
        bookRepo.deleteBookByAuthor(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateBookById/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBook) {
        Optional<Book> oldBook = bookRepo.findById(id);
        if(oldBook.isPresent()) {
            Book updatedBook = oldBook.get();
            updatedBook.setTitle(newBook.getTitle());
            updatedBook.setAuthor(newBook.getAuthor());
            Book book = bookRepo.save(updatedBook);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
