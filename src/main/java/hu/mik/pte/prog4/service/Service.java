package hu.mik.pte.prog4.service;

import hu.mik.pte.prog4.model.Book;

public interface Service<T extends Book> {

    void markCompleted(T book);

}
