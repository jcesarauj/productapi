package com.productapi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.List;

import com.productapi.domain.models.Product;
import com.productapi.repository.ProductRepository;
import com.productapi.domain.models.core.*;

@RestController
@RequestMapping("/products")
public class ProductEndPoint {
    private final ProductRepository _productRepository;

    @Autowired
    public ProductEndPoint(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product) {
        try {
            _productRepository.save(product);
            return new ResponseEntity<>(new Response(true, "Produto adicionado com sucesso", product),
                    HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Response(false, "Erro ao adicionar o produto", product),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<?> FindByName(@PathVariable String name) {
        return new ResponseEntity<>(new Response(true, "", _productRepository.findByNameIgnoreCaseContaining(name)),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product) {
        try {
            var productEntity = _productRepository.findById(product.getId());
            if (productEntity == null) {
                return new ResponseEntity<>(new Response(false, "Produto não encontrado"), HttpStatus.NOT_FOUND);
            }

            _productRepository.save(product);
            return new ResponseEntity<>(new Response(true, "Produto atualizado com sucesso", product), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Response(false, "Erro ao atualizar o produto", product),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            var product = _productRepository.findById(id);

            if (product == null) {
                return new ResponseEntity<>(new Response(false, "Produto não encontrado"), HttpStatus.NOT_FOUND);
            }

            _productRepository.deleteById(id);
            return new ResponseEntity<>(new Response(true, "Produto removido com sucesso"), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Response(false, "Erro ao remover o produto"),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return new ResponseEntity<>(new Response(true, "", _productRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        var product = _productRepository.findById(id);
        HttpStatus httpStatus = (product == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        String message = (product == null ? "Produto não encontrado" : "");
        return new ResponseEntity<>(new Response(false, message, product), httpStatus);
    }
}