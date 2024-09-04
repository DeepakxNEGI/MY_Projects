package com.example.emproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databasee {

    public static void main(String[] args) {
        // JDBC URL, username, and password
        String jdbcUrl = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "MYsql@123";

        // Establishing the connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.println("Connection failed! Error message: " + e.getMessage());
        }
    }
}
