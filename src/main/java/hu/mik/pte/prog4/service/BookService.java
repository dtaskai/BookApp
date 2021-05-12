package hu.mik.pte.prog4.service;

import hu.mik.pte.prog4.entity.Book;
import hu.mik.pte.prog4.repository.BookRepository;
import lombok.extern.log4j.Log4j2;

import java.util.List;


@Log4j2
public class BookService implements Service<Book> {

    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.listAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.updateBook(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        return bookRepository.delete(id);
    }

    @Override
    public void changeCompletion(Book book) {
        book.setCompleted(!book.isCompleted());
        log.info(book + " marked as " + book.isCompleted());
    }

    @Override
    public boolean isValidISBN(Book book) {
        return book.getISBN().matches("^(?:ISBN(?:-13)?:?\\ )?(?=[0-9]{13}$|(?=(?:[0-9]+[-\\ ]){4})[-\\ 0-9]{17}$)97[89][-\\ ]?[0-9]{1,5}[-\\ ]?[0-9]+[-\\ ]?[0-9]+[-\\ ]?[0-9]$");
    }


}
