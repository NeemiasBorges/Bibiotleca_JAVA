package org.me;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final String URL = "jdbc:sqlserver://DEVNEMO;databaseName=gerenciamento_estoque;user=newUser;password=newUser;";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
