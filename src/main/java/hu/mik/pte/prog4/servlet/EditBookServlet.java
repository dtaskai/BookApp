package hu.mik.pte.prog4.servlet;

import hu.mik.pte.prog4.model.Book;
import hu.mik.pte.prog4.repository.BookRepository;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@Log4j2
public class EditBookServlet extends HttpServlet {

    private BookRepository bookRepository;
    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Book> book = bookRepository.findById(id);
        logger.info(book+"");
        req.setAttribute("book", book);
        req.getRequestDispatcher("/EditBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        super.init();
        bookRepository = BookRepository.getInstance();
    }
}
