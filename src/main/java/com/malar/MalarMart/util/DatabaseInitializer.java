package com.malar.MalarMart.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String usersTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id BIGINT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(100) NOT NULL,"
                + "email VARCHAR(150) UNIQUE NOT NULL,"
                + "password VARCHAR(255) NOT NULL,"
                + "role VARCHAR(20) NOT NULL"
                + ")";

        String productsTable = "CREATE TABLE IF NOT EXISTS products ("
                + "id BIGINT AUTO_INCREMENT PRIMARY KEY,"
                + "seller_id BIGINT NOT NULL,"
                + "name VARCHAR(150) NOT NULL,"
                + "description VARCHAR(500),"
                + "price DECIMAL(10,2) NOT NULL,"
                + "quantity INT NOT NULL,"
                + "category VARCHAR(100),"
                + "FOREIGN KEY (seller_id) REFERENCES users(id)"
                + ")";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(usersTable);
            statement.execute(productsTable);

            System.out.println("Database tables created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}