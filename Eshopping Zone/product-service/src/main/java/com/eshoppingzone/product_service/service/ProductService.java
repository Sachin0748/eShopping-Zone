package com.eshoppingzone.product_service.service;

import com.eshoppingzone.product_service.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductsByCategory(String category);
    List<Product> searchProducts(String keyword);
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
