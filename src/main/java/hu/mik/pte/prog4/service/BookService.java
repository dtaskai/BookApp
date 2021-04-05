package hu.mik.pte.prog4.service;

import hu.mik.pte.prog4.model.Book;
import lombok.extern.log4j.Log4j2;
import java.util.logging.Logger;


@Log4j2
public class BookService implements Service<Book>{


    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void changeCompletion(Book book) {
        book.setCompleted(!book.isCompleted());
        logger.info(book + " marked as " + book.isCompleted());
    }

    @Override
    public boolean isValidISBN(Book book) {
        return book.getISBN().matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})\n" +
                "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)\n" +
                "(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$");
    }


}
