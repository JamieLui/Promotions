package com.jamie.service;

import com.jamie.model.Product;
import com.jamie.model.promotions.CheckoutPromotion;
import com.jamie.model.promotions.ProductPromotion;
import com.jamie.repository.CheckoutPromotionRepository;
import com.jamie.repository.ProductPromotionRepository;
import com.jamie.repository.ProductRepository;
import com.jamie.service.promotions.PromotionUtils;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.Optional;


@Service
public class PromotionsService {

    private final CheckoutPromotionRepository checkoutPromotionRepository;
    private final ProductPromotionRepository productPromotionRepository;

    public PromotionsService(final CheckoutPromotionRepository checkoutPromotionRepository, final ProductPromotionRepository productPromotionRepository) {
        this.checkoutPromotionRepository = checkoutPromotionRepository;
        this.productPromotionRepository = productPromotionRepository;
    }

    public CheckoutPromotion addCheckoutPromotion(final CheckoutPromotion checkoutPromotion) throws ValidationException {
        return checkoutPromotionRepository.getOrCreateCheckoutPromotion(checkoutPromotion);
    }

    public Optional<CheckoutPromotion> getCheckoutPromotion(final String checkoutPromotionId) throws ValidationException {
        return checkoutPromotionRepository.findById(checkoutPromotionId);
    }

    public ProductPromotion addProductPromotion(final ProductPromotion productPromotion) throws ValidationException {
        return productPromotionRepository.getOrCreateProductPromotion(productPromotion);
    }

    public Optional<ProductPromotion> getProductPromotion(final String productPromotionId) throws ValidationException {
        return productPromotionRepository.findById(productPromotionId);
    }
}
