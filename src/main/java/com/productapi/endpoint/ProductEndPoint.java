package com.productapi.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.models.Product;
import com.productapi.repository.ProductRepository;
import com.productapi.utils.Response;

@RestController
@RequestMapping("/products")
public class ProductEndPoint {
    private ProductRepository _productRepository;

    public ProductEndPoint() {
        _productRepository = new ProductRepository();
    }

    @GetMapping
    public ResponseEntity<?> Get() {
        return new ResponseEntity<>(new Response(true, "", _productRepository.getProducts()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable("id") int id) {
        var product = _productRepository.getById(id);
        HttpStatus httpStatus = (product == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        String message = (product == null ? "Produto não encontrado" : "");
        return new ResponseEntity<>(new Response(false, message, product), httpStatus);
    }

    @PostMapping
    public void Save(@RequestBody Product product){

    }

    @PutMapping
    public void Updade(@RequestBody Product product){

    }

    @DeleteMapping
    public void Delete(){

    }

    @PatchMapping
    public void UpdatePart(){

    }
}
