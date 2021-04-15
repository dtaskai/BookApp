package hu.mik.pte.prog4.servlet;

import hu.mik.pte.prog4.exception.InvalidISBNException;
import hu.mik.pte.prog4.model.Book;
import hu.mik.pte.prog4.repository.BookRepository;
import hu.mik.pte.prog4.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookServlet extends HttpServlet {

    private BookRepository bookRepository;
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/AddBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvalidISBNException {
        String ISBN = req.getParameter("ISBN");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String genre = req.getParameter("genre");
        int page = Integer.parseInt(req.getParameter("page"));
        int progress = Integer.parseInt(req.getParameter("progress"));
        boolean completed = Boolean.parseBoolean(req.getParameter("completed"));
        int rating = Integer.parseInt(req.getParameter("rating"));

        Book book = new Book(ISBN, title, author, publisher, genre, page, progress, completed, rating);

        if(!bookService.isValidISBN(book)){
            throw new InvalidISBNException();
        }

        bookRepository.saveBook(book);
        resp.sendRedirect("list");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        bookRepository = new BookRepository();
        bookService = new BookService();
    }
}
