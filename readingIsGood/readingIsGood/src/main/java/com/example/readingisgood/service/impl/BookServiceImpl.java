package com.example.readingisgood.service.impl;

import com.example.readingisgood.model.Book;
import com.example.readingisgood.repository.BookRepository;
import com.example.readingisgood.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBook()
    {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book)
    {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findBookById(Long bookId)
    {
        return bookRepository.findById(bookId);
    }
}
