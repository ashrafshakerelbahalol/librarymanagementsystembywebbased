package com.global.librarymanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.global.librarymanagementsystem.entity.Book;
import com.global.librarymanagementsystem.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getallbook")
    public List<Book> getAllBook() {
        return bookService.findAllBook();
    }
    @GetMapping("/getbook/{id}")
    public Book  getBook(@PathVariable int id) {
        return bookService.findBook(id);
    }
    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    @PutMapping("/updatebook")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
    

}
