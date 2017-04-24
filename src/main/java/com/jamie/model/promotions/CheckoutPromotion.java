package com.jamie.model.promotions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.ValidationException;
import java.math.BigDecimal;


@Entity
public class CheckoutPromotion {

    @Id
    private String id;
    private BigDecimal minimumAmountSpent;
    private int percentageDiscount;

    /* for Hiberate */
    public CheckoutPromotion() {}

    public CheckoutPromotion(final String id, final BigDecimal minimumAmountSpent, final int percentageDiscount) throws ValidationException {
        setId(id);
        setMinimumAmountSpent(minimumAmountSpent);
        setPercentageDiscount(percentageDiscount);
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

    public int getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(final int percentageDiscount) throws ValidationException {
        if (percentageDiscount < 0) {
            throw new ValidationException("PercentageDiscount should be over 0%");
        } else if (percentageDiscount >= 100) {
            throw new ValidationException("PercentageDiscount should not be over 100%");
        }

        this.percentageDiscount = percentageDiscount;
    }

    public BigDecimal getMinimumAmountSpent() {
        return minimumAmountSpent;
    }

    public void setMinimumAmountSpent(final BigDecimal minimumAmountSpent) throws ValidationException {
        if (minimumAmountSpent == null || minimumAmountSpent.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Minimum Amount Spent should be a positive number");
        }

        this.minimumAmountSpent = minimumAmountSpent;
    }
}
