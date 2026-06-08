package com.springboot.api.controller;

import com.springboot.api.model.Product;
import com.springboot.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Product REST Controller
 * Handles all CRUD operations for Products
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * GET all products
     * Returns "GET"
     */
    @GetMapping
    public ResponseEntity<String> getAllProducts() {
        return ResponseEntity.ok("GET");
    }

    /**
     * GET product by ID
     * Returns "GET"
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok("GET");
    }

    /**
     * POST - Create a new product
     * Returns "POST" if all required data is provided (name and price)
     */
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        // Check if both required fields are provided
        if (product.getProductName() != null && !product.getProductName().isEmpty()
                && product.getProductPrice() != null && product.getProductPrice() > 0) {
            
            // Save the product
            productService.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("POST");
        }
        
        // Return error if data is incomplete
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error: Product name and price are required");
    }

    /**
     * PUT - Update an existing product
     * Returns "PUT" if at least one field is provided
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // Check if at least one field is provided
        if ((productDetails.getProductName() != null && !productDetails.getProductName().isEmpty())
                || (productDetails.getProductPrice() != null && productDetails.getProductPrice() > 0)) {
            
            Product updatedProduct = productService.updateProduct(id, productDetails);
            if (updatedProduct != null) {
                return ResponseEntity.ok("PUT");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: Product not found");
        }
        
        // Return error if no data is provided
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error: At least one field (name or price) must be provided");
    }

    /**
     * DELETE - Remove a product
     * Returns "DELETE" if product exists
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        // Check if product exists and delete it
        if (productService.deleteProduct(id)) {
            return ResponseEntity.ok("DELETE");
        }
        
        // Return error if product not found
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: Product not found");
    }

}
