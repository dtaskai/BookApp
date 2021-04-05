package hu.mik.pte.prog4.servlet;

import hu.mik.pte.prog4.model.Book;
import hu.mik.pte.prog4.repository.BookRepository;
import hu.mik.pte.prog4.service.BookService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class ModifyCompletionServlet extends HttpServlet {

    private BookRepository bookRepository;
    private BookService bookService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Book> book = bookRepository.findById(id);

        bookService.changeCompletion(book.get());

        bookRepository.updateBook(book.get());
        resp.sendRedirect("list");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        bookRepository = BookRepository.getInstance();
        bookService = new BookService();
    }
}
