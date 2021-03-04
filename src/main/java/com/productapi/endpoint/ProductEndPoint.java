package com.productapi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.productapi.domain.models.Product;
import com.productapi.repository.ProductRepository;
import com.productapi.utils.Response;

@RestController
@RequestMapping("/products")
public class ProductEndPoint {
    
    @Autowired
    private ProductRepository _productRepository;

    @GetMapping
    public ResponseEntity<?> get() {
        return new ResponseEntity<>(new Response(true, "", _productRepository.getProducts()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        var product = _productRepository.getById(id);
        HttpStatus httpStatus = (product == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        String message = (product == null ? "Produto não encontrado" : "");
        return new ResponseEntity<>(new Response(false, message, product), httpStatus);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product) {
        try {
            _productRepository.create(product);
            return new ResponseEntity<>(new Response(true, "Produto adicionado com sucesso", product), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Response(false, "Erro ao adicionar o produto", product),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping
    public void updade(@RequestBody Product product) {

    }

    @DeleteMapping
    public void delete() {

    }

    @PatchMapping
    public void path() {

    }
}
