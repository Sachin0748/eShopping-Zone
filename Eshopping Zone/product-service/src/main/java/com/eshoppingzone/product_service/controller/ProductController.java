package com.eshoppingzone.product_service.controller;

import com.eshoppingzone.product_service.model.Product;
import com.eshoppingzone.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/category/{category}")
    public  ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("/search")
    public  ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        return ResponseEntity.ok(productService.searchProducts(keyword));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/available/{quantity}")
    public ResponseEntity<Boolean> isProductAvailable(@PathVariable Long id, @PathVariable int quantity) {
        try {
            Product product = productService.getProductById(id);
            boolean isAvailable = product.getStockQuantity() >= quantity;
            return ResponseEntity.ok(isAvailable);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
