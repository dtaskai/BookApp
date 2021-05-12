package hu.mik.pte.prog4.rest;

import hu.mik.pte.prog4.entity.Book;
import hu.mik.pte.prog4.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookRestController {

    private final BookService bookService;

    public BookRestController() {
        this.bookService = new BookService();
    }

    @GET
    @Path("/list")
    public Response listAll() {
        List<Book> book = bookService.listAll();
        return Response.status(200).entity(book).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Book book = bookService.findById(id);
        return Response.ok().entity(book).build();
    }

    @POST
    @Path("/add")
    public Response add(Book book) {
        Book addedBook = bookService.save(book);
        return Response.ok().entity(addedBook).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Book bookToUpdate) {
        Book updatedBook = bookService.update(bookToUpdate);
        return Response.ok().entity(updatedBook).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        bookService.delete(id);
        return Response.status(204).build();
    }
}
