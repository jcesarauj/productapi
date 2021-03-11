package com.productapi.repository;

import com.productapi.domain.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByNameIgnoreCaseContaining(String name);
}
