package com.productapi.repository;

import com.productapi.domain.models.Product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNameIgnoreCaseContaining(String name);
}
