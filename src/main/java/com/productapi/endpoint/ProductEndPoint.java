package com.productapi.endpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.models.Product;
import static java.util.Arrays.asList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductEndPoint {
    @GetMapping
    public List<Product> Get() {
        return asList(new Product(1, "xbox one"), new Product(2, "ps4"));
    }
}
