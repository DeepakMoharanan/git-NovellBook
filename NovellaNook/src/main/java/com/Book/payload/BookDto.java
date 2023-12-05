package com.Book.payload;

import lombok.Data;
@Data
public class BookDto {
        private Long id;
        private String name;
        private String author;
        private int publishedYear;
}
