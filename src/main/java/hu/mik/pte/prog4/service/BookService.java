package hu.mik.pte.prog4.service;

import hu.mik.pte.prog4.entity.Book;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class BookService implements Service<Book>{

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
