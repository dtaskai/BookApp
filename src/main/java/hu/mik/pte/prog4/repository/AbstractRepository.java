package hu.mik.pte.prog4.repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractRepository {
    private static final String JNDI_DATASOURCE_NAME = "jdbc/sample";
    private static final String ROOT_CONTEXT = "java:comp/env";

    private static DataSource dataSource;

    protected Connection getConnection() throws NamingException, SQLException {
        return getDataSource().getConnection();
    }

    private static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup(ROOT_CONTEXT);
            dataSource = (DataSource) context.lookup(JNDI_DATASOURCE_NAME);
        }
        return dataSource;
    }
}
