package com.jamie.repository;


import com.jamie.model.promotions.CheckoutPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.bind.ValidationException;
import java.util.Optional;

public interface CheckoutPromotionRepository extends JpaRepository<CheckoutPromotion, String> {

    Optional<CheckoutPromotion> findById(final String id);

    CheckoutPromotion save(final CheckoutPromotion checkoutPromotion);

    default CheckoutPromotion getOrCreateCheckoutPromotion(final CheckoutPromotion checkoutPromotion) throws ValidationException {
        return findById(checkoutPromotion.getId()).orElse(save(checkoutPromotion));
    }
}
