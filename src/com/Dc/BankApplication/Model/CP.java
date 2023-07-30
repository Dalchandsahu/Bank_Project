package com.Dc.BankApplication.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
    // It's better to define connection properties as constants
    private static final String URL = "jdbc:mysql://localhost:3306/bank_manage";
    private static final String USER = "root";
    private static final String PASSWORD = "w@2915djkq#";

    // Method to create a new database connection
    public static Connection createC() throws SQLException {
        Connection con = null;
        try {
            // Load the driver (if you're using JDBC 4.0 or later, this step may be skipped)
            Class.forName("com.mysql.jdbc.Driver");
            
            // Create the connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
        }

        return con;
    }

    // Method to close a database connection
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
