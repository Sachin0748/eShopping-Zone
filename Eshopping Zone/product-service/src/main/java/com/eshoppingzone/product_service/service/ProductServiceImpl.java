package com.eshoppingzone.product_service.service;

import com.eshoppingzone.product_service.exception.ProductNotFoundException;
import com.eshoppingzone.product_service.model.Product;
import com.eshoppingzone.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        log.info("getting all products");
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id){
        log.info("Searching for product with id {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getProductsByCategory(String category){
        log.info("Searching for product with {} category", category);
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> searchProducts(String keyword){
        log.info("Searching for product with {} keyword", keyword);
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public Product saveProduct(Product product){
        log.info("Product {} saved with {} id",product.getName(), product.getId());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails){
        Product product = getProductById(id);

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        product.setStockQuantity(productDetails.getStockQuantity());
        product.setImageUrl(productDetails.getImageUrl());

        log.info("Product with product id {} updated successfully", id);

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id){
        Product product = getProductById(id);
        productRepository.delete(product);
        log.info("Product with id {} deleted!", id);

    }


}
