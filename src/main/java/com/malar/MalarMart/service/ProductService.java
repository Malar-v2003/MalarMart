package com.malar.MalarMart.service;

import com.malar.MalarMart.dao.ProductDAO;
import com.malar.MalarMart.model.Product;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();

    public boolean addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    public List<Product> getProductsBySeller(long sellerId) {
        return productDAO.getProductsBySeller(sellerId);
    }

    public boolean deleteProduct(long productId, long sellerId) {
        return productDAO.deleteProduct(productId, sellerId);
    }

    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }
}