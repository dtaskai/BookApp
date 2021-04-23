package hu.mik.pte.prog4.rest;

import hu.mik.pte.prog4.entity.Book;
import hu.mik.pte.prog4.repository.BookRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController() {
        this.bookRepository = new BookRepository();
    }

    @GET
    @Path("/list")
    public Response listAll() {
        List<Book> book = bookRepository.listAll();
        return Response.status(200).entity(book).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Book book = bookRepository.findById(id);
        return Response.ok().entity(book).build();
    }

    @POST
    @Path("/add")
    public Response add(Book book) {
        Book addedBook = bookRepository.saveBook(book);
        return Response.ok().entity(addedBook).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Book bookToUpdate) {
        Book updatedBook = bookRepository.updateBook(bookToUpdate);
        return Response.ok().entity(updatedBook).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        bookRepository.delete(id);
        return Response.status(204).build();
    }
}
