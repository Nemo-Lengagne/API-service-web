package com.springboot.api.service;

import com.springboot.api.model.Product;
import com.springboot.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Product Service Class
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get product by ID
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Create a new product
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Update an existing product
     */
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            if (productDetails.getProductName() != null && !productDetails.getProductName().isEmpty()) {
                existingProduct.setProductName(productDetails.getProductName());
            }
            if (productDetails.getProductPrice() != null && productDetails.getProductPrice() > 0) {
                existingProduct.setProductPrice(productDetails.getProductPrice());
            }
            return productRepository.save(existingProduct);
        }
        return null;
    }

    /**
     * Delete a product by ID
     */
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
