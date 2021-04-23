package hu.mik.pte.prog4.controller;

import hu.mik.pte.prog4.entity.Book;
import hu.mik.pte.prog4.repository.BookRepository;
import hu.mik.pte.prog4.service.BookService;

import java.util.List;

@Deprecated
public class Control {

    private static Long id = 1L;
    private List<Book> dummyData;
    private BookService bookService;
    private BookRepository bookRepository;

    public Control(BookService bookService) {
        this.bookService = bookService;
        this.bookRepository = new BookRepository();
    }

    public void start() {
        dummyData = bookRepository.listAll();
        createDummyData();
        for(Book book : dummyData) {
            bookService.changeCompletion(book);
        }
    }

    private void createDummyData() {

    }
}
