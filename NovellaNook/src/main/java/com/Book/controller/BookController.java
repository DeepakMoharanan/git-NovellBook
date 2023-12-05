package com.Book.controller;

import com.Book.payload.BookDto;
import com.Book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("api/book")
public class BookController  {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    //http://localhost:8080/api/book
    @PostMapping
    public ResponseEntity<BookDto>createBook(@RequestBody BookDto bookDto){
        BookDto createdBook = bookService.cerateBook(bookDto);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
    //Get All Post
    //http://localhost:8080/api/book
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    //http://localhost:8080/api/book/id{1}
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getBookById(@PathVariable(name = "id") Long id) {
        BookDto foundBook = bookService.getBookById(id);
        if (foundBook != null) {
            return new ResponseEntity<>(foundBook, HttpStatus.OK);
        } else {
            String errorMessage = "Book not found with ID: " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
    //http://localhost:8080/api/book/{1}
     @PutMapping("/id")
     public ResponseEntity<?>updateBook(@RequestBody BookDto bookDto, @PathVariable(name="id")Long id){
         BookDto bookResponse = bookService.updateBook(bookDto, id);
             return new ResponseEntity<>("Book not Avalibale ", HttpStatus.NOT_FOUND);
     }
    //http://localhost:8080/api/book/id{1}
     @DeleteMapping("/id")
    public  ResponseEntity<?> deleteBookById(@PathVariable(name = "id")Long id){
        bookService.deleteBookById(id);
         return new ResponseEntity<>("Book not available", HttpStatus.NOT_FOUND);
     }
}
