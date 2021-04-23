package hu.mik.pte.prog4.servlet;

import hu.mik.pte.prog4.entity.Book;
import hu.mik.pte.prog4.repository.BookRepository;
import hu.mik.pte.prog4.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyCompletionServlet extends HttpServlet {

    private BookRepository bookRepository;
    private BookService bookService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Book book = bookRepository.findById(id);

        bookService.changeCompletion(book);

        bookRepository.updateBook(book);
        resp.sendRedirect("list");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        bookRepository = new BookRepository();
        bookService = new BookService();
    }
}
