package com.jamie.service;

import com.jamie.model.Product;
import com.jamie.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(final Product product) throws ValidationException {
        repository.getOrCreateProduct(product);
    }

    public Optional<Product> getProductById(final String productId) {
        return repository.findById(productId);
    }
}
