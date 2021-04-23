package hu.mik.pte.prog4.repository;

import hu.mik.pte.prog4.entity.User;
import lombok.extern.log4j.Log4j2;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class UserRepository extends AbstractRepository {

    public User findByUsername(String username) {
        try (Connection con = this.getConnection(); PreparedStatement statement = con.prepareStatement(
                "SELECT u.id, u.username, u.\"password\" from \"user\" u where u.username = ?"
        )) {
            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                log.info("User: " + user);
                return user;
            }
        } catch (SQLException | NamingException e) {
            log.error("Something went wrong: " + e.getMessage(), e);
            throw new RuntimeException();
        }
    }
}
