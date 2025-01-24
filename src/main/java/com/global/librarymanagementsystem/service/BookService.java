package com.global.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.librarymanagementsystem.entity.Book;
import com.global.librarymanagementsystem.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBook() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book addBook(Book book) {
        Book currentBook = new Book();
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setIsbn(book.getIsbn());
        currentBook.setGenre(book.getGenre());
        currentBook.setPublisher(book.getPublisher());
        currentBook.setQuantity(book.getQuantity());
        currentBook.setYearOfPublication(book.getYearOfPublication());

        return bookRepository.save(currentBook);
    }

    public Book updateBook(Book book) {
        Book currentBook = bookRepository.findById(book.getId()).get();
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setIsbn(book.getIsbn());
        currentBook.setGenre(book.getGenre());
        currentBook.setPublisher(book.getPublisher());
        currentBook.setYearOfPublication(book.getYearOfPublication());

        return bookRepository.save(currentBook);
    }

    public Book updateQuantity(int id, boolean increaseQuantity) {
        Book currentBook = bookRepository.findById(id).get();
        if (increaseQuantity)
            currentBook.setQuantity(currentBook.getQuantity() + 1);
        else
            currentBook.setQuantity(currentBook.getQuantity() - 1);
        return bookRepository.save(currentBook);
    }

    public Book findBook(int id) {
        return bookRepository.findById(id).get();
    }

    public void deleteBook(int id) {
        Book bookToDelete = bookRepository.findById(id).get();
        bookRepository.delete(bookToDelete);
    }

}
