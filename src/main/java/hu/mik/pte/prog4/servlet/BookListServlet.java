package hu.mik.pte.prog4.servlet;

import hu.mik.pte.prog4.model.Book;
import hu.mik.pte.prog4.repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookListServlet extends HttpServlet {

    private BookRepository bookRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        books.addAll(bookRepository.listAll());
        req.setAttribute("books",books);
        req.getRequestDispatcher("/BookList.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        this.bookRepository = new BookRepository();
    }
}
