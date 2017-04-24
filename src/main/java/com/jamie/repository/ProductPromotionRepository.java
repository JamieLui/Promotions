package com.jamie.repository;


import com.jamie.model.promotions.ProductPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.bind.ValidationException;
import java.util.Optional;

public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, String> {

    Optional<ProductPromotion> findById(final String id);

    ProductPromotion save(final ProductPromotion productPromotion);

    default ProductPromotion getOrCreateProductPromotion(final ProductPromotion productPromotion) throws ValidationException {
        return findById(productPromotion.getId()).orElse(save(productPromotion));
    }
}
