package com.emlakcepteservice.service;

import com.emlakcepteservice.model.Product;
import com.emlakcepteservice.repository.ProductRepository;
import com.emlakcepteservice.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final int maxQuantity = 10;
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(ProductRequest productRequest) {
        Product product = convert(productRequest);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    private Product convert(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setQuantity(productRequest.getQuantity());
        LocalDate expirationDate = product.getExpirationDate();
        if (expirationDate == null) {
            expirationDate = LocalDate.now();
        }
        product.setExpirationDate(expirationDate.plusDays(30));
        return product;

    }

    public Optional<Product> getById(Integer id) {

        return productRepository.findById(id);
    }

    public void update(ProductRequest productRequest, Integer id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product product1 = product.get();
            product1.setProductName(productRequest.getProductName());
            product1.setQuantity(productRequest.getQuantity());
            this.productRepository.save(product1);
        }
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}

