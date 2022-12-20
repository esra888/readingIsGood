package com.example.readingisgood.controller;

import com.example.readingisgood.model.Book;
import com.example.readingisgood.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks()
    {
        return bookService.getAllBook();
    }

    @PostMapping
    public Book createBook(@RequestBody Book bookRequest)
    {
        Book book = bookService.createBook(new Book(bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getQuantity(), bookRequest.getPrice()));
        return book;
    }
}
