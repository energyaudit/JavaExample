package main.Java3.Junit5.extensions;


import main.Java3.Junit5.helpers.EmployeeJdbcDao;
import main.Java3.Junit5.helpers.JdbcConnectionUtil;
import org.junit.jupiter.api.extension.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

public class EmployeeDatabaseSetupExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private Connection con;
    private EmployeeJdbcDao employeeDao;
    private Savepoint savepoint;

    public EmployeeDatabaseSetupExtension() {
        con = JdbcConnectionUtil.getConnection();
        employeeDao = new EmployeeJdbcDao(con);
    }

    public EmployeeDatabaseSetupExtension(String jdbcUrl, String driver, String username, String password) {
        con = JdbcConnectionUtil.getConnection(jdbcUrl, driver, username, password);
        employeeDao = new EmployeeJdbcDao(con);
    }

    @Override
    public void afterAll(ExtensionContext context) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    @Override
    public void beforeAll(ExtensionContext context) throws SQLException {
        employeeDao.createTable();

    }

    @Override
    public void afterEach(ExtensionContext context) throws SQLException {
        con.rollback(savepoint);
    }

    @Override
    public void beforeEach(ExtensionContext context) throws SQLException {
        con.setAutoCommit(false);
        savepoint = con.setSavepoint("before");
    }

}
