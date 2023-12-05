package com.Book.service;

import com.Book.payload.BookDto;

import java.util.List;

public interface BookService {
    BookDto cerateBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    BookDto updateBook(BookDto bookDto, Long id);

    boolean deleteBookById(Long id);
}
