package hu.mik.pte.prog4.repository;

import hu.mik.pte.prog4.entity.Role;
import hu.mik.pte.prog4.entity.User;
import lombok.extern.log4j.Log4j2;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class RoleRepository extends AbstractRepository {
    public List<Role> findRolesByUser(User user) {
        try (Connection con = this.getConnection(); PreparedStatement statement = con.prepareStatement(
                "SELECT r.id, r.code, r.description FROM role r JOIN user_role ur ON r.id = ur.role_id WHERE ur.user_id = ?"
        )) {
            statement.setLong(1, user.getId());
            try (ResultSet rs = statement.executeQuery()) {
                List<Role> roles = new ArrayList<>();
                while (rs.next()) {
                    Role role = new Role();
                    role.setId(rs.getLong("id"));
                    role.setCode(rs.getString("code"));
                    role.setDescription(rs.getString("description"));
                    roles.add(role);
                }
                roles.forEach(log::info);
                return roles;
            }
        } catch (SQLException | NamingException e) {
            log.error("Something went wrong: " + e.getMessage(), e);
            throw new RuntimeException();
        }
    }
}
