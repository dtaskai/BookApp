package hu.mik.pte.prog4.service;

import hu.mik.pte.prog4.model.Book;
import lombok.extern.log4j.Log4j2;
import java.util.logging.Logger;


@Log4j2
public class BookService implements Service<Book>{


    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void markCompleted(Book book) {
        book.setCompleted(!book.isCompleted());
        logger.info(book + " marked as " + book.isCompleted());
    }

}
