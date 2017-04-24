package com.jamie.model.promotions;

import com.jamie.model.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.Map;

@Entity
public class ProductPromotion {

    @Id
    private String id;
    private String productId;
    private int amountRequiredForPromotion;
    private BigDecimal newProductPrice;

    /* for Hiberate */
    public ProductPromotion() {}

    public ProductPromotion(final String id, final String productId, final int amountRequiredForPromotion, final BigDecimal newProductPrice) throws ValidationException {
        setId(id);
        setProductId(productId);
        setAmountRequiredForPromotion(amountRequiredForPromotion);
        setNewProductPrice(newProductPrice);
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) throws ValidationException {

        if (id == null || id.isEmpty()) {
            throw new ValidationException("Product can not be null");
        }

        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String productId) throws ValidationException {

        if (productId == null) {
            throw new ValidationException("Product can not be null");
        }

        this.productId = productId;
    }

    public int getAmountRequiredForPromotion() {
        return amountRequiredForPromotion;
    }

    public void setAmountRequiredForPromotion(final int amountRequiredForPromotion) throws ValidationException {
        if (amountRequiredForPromotion < 0) {
            throw new ValidationException("For a product promotion please select how many purchases are required before promotion is valid");
        }

        this.amountRequiredForPromotion = amountRequiredForPromotion;
    }

    public BigDecimal getNewProductPrice() {
        return newProductPrice;
    }

    public void setNewProductPrice(final BigDecimal newProductPrice) throws ValidationException {
        if (newProductPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Price must be more than zero");
        }

        this.newProductPrice = newProductPrice;
    }

}
