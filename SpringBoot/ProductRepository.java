package com.springboot.api.repository;

import com.springboot.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Product Repository Interface
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
