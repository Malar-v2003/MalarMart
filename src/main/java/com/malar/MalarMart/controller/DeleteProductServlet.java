package com.malar.MalarMart.controller;

import com.malar.MalarMart.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-product")
public class DeleteProductServlet extends HttpServlet {

    private final ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long productId = Long.parseLong(request.getParameter("productId"));

        // Temporary seller ID for testing
        long sellerId = 1;

        boolean deleted = productService.deleteProduct(productId, sellerId);

        if (deleted) {
            response.sendRedirect("seller-products.jsp");
        } else {
            response.getWriter().println("Failed to delete product.");
        }
    }
}