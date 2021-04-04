package com.jpeony.reflect.spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yihonglei
 */
public class JdbcSPITest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/jpeony?serverTimezone=UTC";

        String user = "root";
        String password = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
