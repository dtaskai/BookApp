package hu.mik.pte.prog4.service;

import hu.mik.pte.prog4.entity.Book;

import java.util.List;

public interface Service<T extends Book> {

    List<T> listAll();

    T save(T book);

    T update(T book);

    T findById(Long id);

    boolean delete(Long id);

    void changeCompletion(T book);

    boolean isValidISBN(T book);
}
