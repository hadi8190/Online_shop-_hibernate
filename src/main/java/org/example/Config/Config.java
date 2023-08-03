package org.example.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String pass = "2002";


    Connection myConn;

    {
        try {
            myConn = DriverManager.getConnection(jdbcUrl, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
