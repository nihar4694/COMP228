package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:oracle:thin:@//199.212.26.208:1521/SQLD";
    private static final String USER = "COMP228_F24_soh_41";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        // Load the Oracle JDBC driver
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        }

        // Establish and return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}