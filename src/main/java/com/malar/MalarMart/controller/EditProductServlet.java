package com.malar.MalarMart.controller;

import com.malar.MalarMart.model.Product;
import com.malar.MalarMart.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-product")
public class EditProductServlet extends HttpServlet {

    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long productId = Long.parseLong(request.getParameter("productId"));

        long sellerId = 1;

        Product product = null;

        for (Product p : productService.getProductsBySeller(sellerId)) {

            if (p.getId() == productId) {
                product = p;
                break;
            }
        }

        if (product != null) {

            request.setAttribute("product", product);

            request.getRequestDispatcher("/edit-product.jsp")
                   .forward(request, response);

        } else {

            response.getWriter().println("Product not found.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long productId = Long.parseLong(request.getParameter("productId"));

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        double price = Double.parseDouble(request.getParameter("price"));

        int quantity = Integer.parseInt(request.getParameter("quantity"));

        String category = request.getParameter("category");

        long sellerId = 1;

        Product product = new Product(
                productId,
                sellerId,
                name,
                description,
                price,
                quantity,
                category
        );

        boolean updated = productService.updateProduct(product);

        if (updated) {

            response.sendRedirect("seller-products.jsp");

        } else {

            response.getWriter().println("Failed to update product.");
        }
    }
}