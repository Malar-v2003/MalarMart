package com.malar.MalarMart.dao;

import com.malar.MalarMart.model.Product;
import com.malar.MalarMart.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean addProduct(Product product) {

        String sql = "INSERT INTO products "
                + "(seller_id, name, description, price, quantity, category) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, product.getSellerId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getQuantity());
            statement.setString(6, product.getCategory());

            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getProductsBySeller(long sellerId) {

        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM products WHERE seller_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, sellerId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Product product = new Product(
                        result.getLong("id"),
                        result.getLong("seller_id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getDouble("price"),
                        result.getInt("quantity"),
                        result.getString("category")
                );

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public boolean deleteProduct(long productId, long sellerId) {

        String sql = "DELETE FROM products "
                + "WHERE id = ? AND seller_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, productId);
            statement.setLong(2, sellerId);

            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateProduct(Product product) {

    String sql = "UPDATE products SET "
            + "name = ?, "
            + "description = ?, "
            + "price = ?, "
            + "quantity = ?, "
            + "category = ? "
            + "WHERE id = ? AND seller_id = ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setDouble(3, product.getPrice());
        statement.setInt(4, product.getQuantity());
        statement.setString(5, product.getCategory());
        statement.setLong(6, product.getId());
        statement.setLong(7, product.getSellerId());

        int rows = statement.executeUpdate();

        return rows > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}