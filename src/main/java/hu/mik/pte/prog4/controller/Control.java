package hu.mik.pte.prog4.controller;

import hu.mik.pte.prog4.model.Book;
import hu.mik.pte.prog4.repository.BookRepository;
import hu.mik.pte.prog4.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class Control {

    private static Long id = 1L;
    private List<Book> dummyData;
    private BookService bookService;
    private BookRepository bookRepository;

    public Control(BookService bookService) {
        this.bookService = bookService;
        this.bookRepository = BookRepository.getInstance();
    }

    public void start() {
        dummyData = bookRepository.listAll();
        createDummyData();
        for(Book book : dummyData) {
            bookService.markCompleted(book);
        }
    }

    private void createDummyData() {

    };
}
