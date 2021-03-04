package com.productapi.repository;

import java.util.List;
import static java.util.Arrays.asList;
import java.util.ArrayList;
import com.productapi.models.Product;

public class ProductRepository {
    private List<Product> _products;

    public ProductRepository() {
        _products = new ArrayList<>(asList(new Product(1, "xbox360"), new Product(2, "ps1")));
    }

    public void Add(Product product){
        _products.add(product);
    }

    public List<Product> getProducts() {
        return _products;
    }

    public Product getById(int id) {
        Product product = new Product();
        product.setId(id);
        int index = _products.indexOf(product);
        if (index == -1)
            return null;
        else
            return _products.get(index);
    }
}
