package com.Book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "published_Year",nullable = false)
    private int publishedYear;

}

