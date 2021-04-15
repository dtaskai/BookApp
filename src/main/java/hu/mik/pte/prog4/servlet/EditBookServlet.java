package hu.mik.pte.prog4.servlet;

import hu.mik.pte.prog4.model.Book;
import hu.mik.pte.prog4.repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditBookServlet extends HttpServlet {

    private BookRepository bookRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Book book = bookRepository.findById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/EditBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String ISBN = req.getParameter("ISBN");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String genre = req.getParameter("genre");
        int page = Integer.parseInt(req.getParameter("page"));
        int progress = Integer.parseInt(req.getParameter("progress"));
        boolean completed = Boolean.parseBoolean(req.getParameter("completed"));
        int rating = Integer.parseInt(req.getParameter("rating"));

        Book book = new Book(id, ISBN, title, author, publisher, genre, page, progress, completed, rating);

        bookRepository.updateBook(book);
        resp.sendRedirect("list");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        bookRepository = new BookRepository();
    }
}
