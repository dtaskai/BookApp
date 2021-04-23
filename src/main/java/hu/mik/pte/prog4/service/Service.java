package hu.mik.pte.prog4.service;

import hu.mik.pte.prog4.entity.Book;

public interface Service<T extends Book> {

    void changeCompletion(T book);

    boolean isValidISBN(T book);
}
