package com.example.readingisgood.service;

import com.example.readingisgood.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService
{
    List<Book> getAllBook();

    Book createBook(Book book);

    Optional<Book> findBookById(Long bookId);
}
