package hu.mik.pte.prog4.repository;

import hu.mik.pte.prog4.entity.Book;
import lombok.extern.log4j.Log4j2;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class BookRepository extends AbstractRepository {

    public List<Book> listAll() {
        try (Connection con = this.getConnection(); Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT id, isbn, title, author, publisher, genre, page, progress, completed, rating, addedby FROM book");
            List<Book> list = new ArrayList<>();
            while (rs.next()) {
                list.add(this.mapBook(rs));
            }
            return list;
        } catch (SQLException | NamingException e) {
            log.error("Something went wrong: " + e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public Book saveBook(Book newBook) {
        try (Connection con = this.getConnection(); PreparedStatement statement = con.prepareStatement(
                "INSERT INTO book (isbn, title, author, publisher, genre, page, progress, completed, rating, addedby) values (?,?,?,?,?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS
        )) {
            statement.setString(1, newBook.getISBN());
            statement.setString(2, newBook.getTitle());
            statement.setString(3, newBook.getAuthor());
            statement.setString(4, newBook.getPublisher());
            statement.setString(5, newBook.getGenre());
            statement.setInt(6, newBook.getPage());
            statement.setInt(7, newBook.getProgress());
            statement.setBoolean(8, newBook.isCompleted());
            statement.setInt(9, newBook.getRating());
            statement.setString(10, newBook.getAddedBy());

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            return this.findById(generatedKeys.getLong(1));
        } catch (SQLException | NamingException e) {
            log.error("Something went wrong: " + e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public Book updateBook(Book bookToUpdate) {
        try (Connection con = this.getConnection(); PreparedStatement statement = con.prepareStatement(
                "UPDATE book SET isbn = ?, title = ?, author = ?, publisher = ?, genre = ?, page = ?, progress = ?, completed = ?, rating = ? WHERE id = ?",
                Statement.RETURN_GENERATED_KEYS
        )) {
            statement.setString(1, bookToUpdate.getISBN());
            statement.setString(2, bookToUpdate.getTitle());
            statement.setString(3, bookToUpdate.getAuthor());
            statement.setString(4, bookToUpdate.getPublisher());
            statement.setString(5, bookToUpdate.getGenre());
            statement.setInt(6, bookToUpdate.getPage());
            statement.setInt(7, bookToUpdate.getProgress());
            statement.setBoolean(8, bookToUpdate.isCompleted());
            statement.setInt(9, bookToUpdate.getRating());
            statement.setLong(10, bookToUpdate.getId());

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            return this.findById(bookToUpdate.getId());
        } catch (SQLException | NamingException e) {
            log.error("Something went wrong: " + e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public Book findById(Long id) {
        try (Connection con = this.getConnection(); PreparedStatement statement = con.prepareStatement(
                "SELECT id, isbn, title, author, publisher, genre, page, progress, completed, rating, addedby FROM book WHERE id = ?"
        )) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return this.mapBook(rs);
        } catch (SQLException | NamingException e) {
            log.error("Something went wrong: " + e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public boolean delete(Long id) {
        try (Connection con = this.getConnection(); PreparedStatement statement = con.prepareStatement(
                "DELETE FROM book WHERE id = ?"
        )) {
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | NamingException e) {
            log.error("Something went wrong: " + e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setISBN(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setGenre(rs.getString("genre"));
        book.setPage(rs.getInt("page"));
        book.setProgress(rs.getInt("progress"));
        book.setCompleted(rs.getBoolean("completed"));
        book.setRating(rs.getInt("rating"));
        book.setAddedBy(rs.getString("addedby"));
        return book;
    }

}
