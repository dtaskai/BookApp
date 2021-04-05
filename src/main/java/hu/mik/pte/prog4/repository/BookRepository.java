package hu.mik.pte.prog4.repository;

import hu.mik.pte.prog4.model.Book;
import hu.mik.pte.prog4.util.IdProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookRepository {

    private static final BookRepository BOOK_REPOSITORY = new BookRepository();
    private final IdProvider idProvider;

    private final ArrayList<Book> bookList;

    public BookRepository() {
        idProvider = IdProvider.getInstance();
        bookList = initList();
    }

    public List<Book> listAll() {
        return new ArrayList<>(bookList);
    }

    public Book addBook(Book newBook) {
        newBook.setId(idProvider.nextId());
        bookList.add(newBook);
        return newBook;
    }

    public Book updateBook(Book updatedBook) {
        Book current = bookList.stream().filter(b -> b.getId().equals(updatedBook.getId())).findFirst().get();
        int i = bookList.indexOf(current);
        bookList.set(i, updatedBook);
        return updatedBook;
    }

    public Optional<Book> findById(Long id) {
        return bookList.stream().filter(b -> Objects.equals(id, b.getId())).findFirst();
    }

    public boolean delete(Long id) {
        Optional<Book> book = bookList.stream().filter(b -> Objects.equals(b.getId(), id)).findFirst();

        return book.map(this.bookList::remove).orElse(false);
    }

    public static BookRepository getInstance() {
        return BOOK_REPOSITORY;
    }

    private ArrayList<Book> initList() {
        ArrayList<Book> dummyList = new ArrayList<>();

        dummyList.add(new Book(
                idProvider.nextId(),
                "0-6381-5268-2",
                "Pilots Of Dusk",
                "Shamas Driscoll",
                "Oculus",
                "Fantasy",
                300,
                0,
                false,
                null
        ));
        dummyList.add(new Book(
                idProvider.nextId(),
                "0-8949-4717-6",
                "Heir Of The End",
                "Samara Ellis",
                "Weilly",
                "Adventure",
                450,
                0,
                false,
                null
        ));
        dummyList.add(new Book(
                idProvider.nextId(),
                "0-6490-3442-2",
                "Scourge Of History",
                "Kelise Ferguson",
                "Papyrus",
                "Horror",
                630,
                0,
                false,
                null
        ));
        dummyList.add(new Book(
                idProvider.nextId(),
                "0-6266-0581-4",
                "Technology Of The Oceans",
                "Enzo Mcdermott",
                "Pyramid",
                "Science",
                210,
                0,
                false,
                null
        ));
        dummyList.add(new Book(
                idProvider.nextId(),
                "0-5844-8747-9",
                "Bored By Time Travel",
                "Elana Shah",
                "Prosper",
                "Science",
                540,
                0,
                false,
                null
        ));
        dummyList.add(new Book(
                idProvider.nextId(),
                "0-3515-0094-4",
                "Amusing Art",
                "Hayden Cannon",
                "Minor",
                "Art",
                180,
                0,
                false,
                null
        ));

        return dummyList;
    }
}
