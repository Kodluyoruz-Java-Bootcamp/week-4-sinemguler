package com.emlakcepteservice.controller;

import com.emlakcepteservice.model.Product;
import com.emlakcepteservice.request.ProductRequest;
import com.emlakcepteservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest productRequest) {
        Product product = productService.create(productRequest);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PutMapping("/{id}")
    public void update(@RequestBody() ProductRequest productRequest, int id) throws Exception {
        this.productService.update(productRequest, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return "deleted " + id;
    }
}