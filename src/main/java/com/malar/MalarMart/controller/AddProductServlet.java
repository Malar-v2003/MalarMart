package com.malar.MalarMart.controller;

import com.malar.MalarMart.model.Product;
import com.malar.MalarMart.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {

    private final ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String category = request.getParameter("category");

        // Temporary seller ID for testing
        long sellerId = 1;

        Product product = new Product(
                0,
                sellerId,
                name,
                description,
                price,
                quantity,
                category
        );

        boolean added = productService.addProduct(product);

        if (added) {
            response.getWriter().println("Product added successfully!");
        } else {
            response.getWriter().println("Failed to add product.");
        }
    }
}