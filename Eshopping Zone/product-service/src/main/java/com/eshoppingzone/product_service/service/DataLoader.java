package com.eshoppingzone.product_service.service;

import com.eshoppingzone.product_service.model.Product;
import com.eshoppingzone.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            // Only load data if repository is empty
            if (repository.count() == 0) {
                repository.save(new Product(null, "iPhone 13", "Apple's latest smartphone with A15 Bionic chip", 799.99, "Electronics", 50, "https://example.com/iphone13.jpg"));
                repository.save(new Product(null, "Samsung Galaxy S21", "Flagship Android smartphone", 699.99, "Electronics", 45, "https://example.com/galaxys21.jpg"));
                repository.save(new Product(null, "MacBook Pro", "Powerful laptop for professionals", 1299.99, "Electronics", 30, "https://example.com/macbookpro.jpg"));
                repository.save(new Product(null, "Nike Air Max", "Comfortable running shoes", 129.99, "Apparel", 100, "https://example.com/nikeairmax.jpg"));
                repository.save(new Product(null, "The Alchemist", "Novel by Paulo Coelho", 15.99, "Books", 200, "https://example.com/alchemist.jpg"));
                repository.save(new Product(null, "Face Moisturizer", "Hydrating facial cream", 24.99, "Personal-Care", 150, "https://example.com/moisturizer.jpg"));
            }
        };
    }
}