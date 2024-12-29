package com.global.librarymanagementsystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book")
public class Book {
    @Id
    @Column("book_id")
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    @Column("year_of_publication")
    private String yearOfPublication;
    private String isbn;
    private String genre;
    private int quantity;
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getYearOfPublication() {
        return yearOfPublication;
    }
    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Book() {
    }
    public Book(int id, String title, String author, String publisher, String yearOfPublication, String isbn,
            String genre, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.isbn = isbn;
        this.genre = genre;
        this.quantity = quantity;
    }

}
