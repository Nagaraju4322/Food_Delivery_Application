package com.raju.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1) Check if running inside Docker
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String pass = System.getenv("DB_PASS");

            if (url != null) {
                // Running inside Docker
                connection = DriverManager.getConnection(url, user, pass);
            } 
            else {
                // Running in Eclipse (your laptop)
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/foodie_application",
                    "root",
                    "Raju@4322"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
