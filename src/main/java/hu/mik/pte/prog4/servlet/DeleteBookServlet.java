package hu.mik.pte.prog4.servlet;

import hu.mik.pte.prog4.repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {

    private BookRepository bookRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        bookRepository.delete(id);
        resp.sendRedirect("list");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        bookRepository = BookRepository.getInstance();
    }
}
