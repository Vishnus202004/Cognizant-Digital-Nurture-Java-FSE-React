package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerNewBook(String bookName) {
        System.out.println("⚙️ [Service] Processing book registration business rules for: " + bookName);
        bookRepository.saveBook(bookName);
    }
}