package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameLike(String name);
}
