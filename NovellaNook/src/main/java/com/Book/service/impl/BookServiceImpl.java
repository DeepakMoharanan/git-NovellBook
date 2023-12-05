package com.Book.service.impl;

import com.Book.entity.Book;
import com.Book.payload.BookDto;
import com.Book.repository.BookRepository;
import com.Book.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    public BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public BookDto cerateBook(BookDto bookDto) {
        Book book = mapToEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        BookDto dto = mapToDto(savedBook);
        return dto;
    }
    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> mapToDto(book))
                .collect(Collectors.toList());
    }
    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElse(null);
        if (book != null) {
            return mapToDto(book);
        } else {
            return null;
        }
    }
    @Override
    public BookDto updateBook(BookDto bookDto, Long id) {
        Book book = bookRepository.findById(id)
                .orElse(null);
        if (book != null) {
            book.setName(bookDto.getName());
            book.setAuthor(bookDto.getAuthor());
            book.setPublishedYear(bookDto.getPublishedYear());
            Book updatedBook = bookRepository.save(book);
            return mapToDto(updatedBook);
        } else {
            return null;
        }
    }
    @Override
    public boolean deleteBookById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    private Book mapToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setPublishedYear(bookDto.getPublishedYear());
        return book;
    }
    private BookDto mapToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPublishedYear(book.getPublishedYear());
        return bookDto;
    }
}

