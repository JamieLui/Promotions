package com.jamie.repository;


import com.jamie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.bind.ValidationException;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findById(final String id);

    Product save(final Product product);

    default Product getOrCreateProduct(final Product product) throws ValidationException {
        return findById(product.getId()).orElse(save(product));
    }
}
