//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.*;
//
//public class GamePlayerManagementApp {
//    private static Connection connection;
//
//    public static void main(String[] args) {
//        connectToDatabase();
//        SwingUtilities.invokeLater(() -> new MainGUI());
//    }
//
//    private static void connectToDatabase() {
//        try {
//            connection = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:xe", COMP228_F24_soh_41, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Database connection failed!");
//        }
//    }
//
//    public static Connection getConnection() {
//        return connection;
//    }
//}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:SQLD", "COMP228_F24_soh_41", "password");
            System.out.println("Connected to Oracle Database!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

