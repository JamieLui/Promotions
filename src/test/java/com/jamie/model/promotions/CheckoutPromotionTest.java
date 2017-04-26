package com.jamie.model.promotions;

import org.hamcrest.core.Is;
import org.junit.Test;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.*;


public class CheckoutPromotionTest {

    @Test
    public void checkoutPromotionTestCreateObjectSuccess() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        String id = String.valueOf(randomGenerator.nextInt());
        BigDecimal minimumSpentAmount = BigDecimal.valueOf(randomGenerator.nextInt(100));
        int percentageDiscount = randomGenerator.nextInt(100);

        // Test
        CheckoutPromotion checkoutPromotion = new CheckoutPromotion(id, minimumSpentAmount, percentageDiscount);

        // Result
        assertNotNull(checkoutPromotion);
        assertThat(checkoutPromotion.getId(), Is.is(id));
        assertThat(checkoutPromotion.getMinimumAmountSpent(), Is.is(minimumSpentAmount));
        assertThat(checkoutPromotion.getPercentageDiscount(), Is.is(percentageDiscount));
    }

    @Test
    public void checkoutPromotionTestCreateObjectFailureNullId() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        BigDecimal minimumSpentAmount = BigDecimal.valueOf(randomGenerator.nextInt(100));
        int percentageDiscount = -10;
        ValidationException validationException = null;

        // Test
        try {
            new CheckoutPromotion(null, minimumSpentAmount, percentageDiscount);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Result
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Product can not be null or empty"));
    }

    @Test
    public void checkoutPromotionTestCreateObjectFailureEmptyId() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        BigDecimal minimumSpentAmount = BigDecimal.valueOf(randomGenerator.nextInt(100));
        int percentageDiscount = -10;
        ValidationException validationException = null;

        // Test
        try {
            new CheckoutPromotion("", minimumSpentAmount, percentageDiscount);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Result
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Product can not be null or empty"));
    }

    @Test
    public void checkoutPromotionTestCreateObjectFailureMinusPercentage() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        String id = String.valueOf(randomGenerator.nextInt());
        BigDecimal minimumSpentAmount = BigDecimal.valueOf(randomGenerator.nextInt(100));
        int percentageDiscount = -10;
        ValidationException validationException = null;

        // Test
        try {
            new CheckoutPromotion(id, minimumSpentAmount, percentageDiscount);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Result
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("PercentageDiscount should be over 0%"));
    }

    @Test
    public void checkoutPromotionTestCreateObjectFailureOneHundredPercentageOff() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        String id = String.valueOf(randomGenerator.nextInt());
        BigDecimal minimumSpentAmount = BigDecimal.valueOf(randomGenerator.nextInt(100));
        int percentageDiscount = 100;
        ValidationException validationException = null;

        // Test
        try {
            new CheckoutPromotion(id, minimumSpentAmount, percentageDiscount);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Result
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("PercentageDiscount should not be over 100%"));
    }

    @Test
    public void checkoutPromotionTestCreateObjectFailureMinusMinimumSpend() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        String id = String.valueOf(randomGenerator.nextInt());
        BigDecimal minimumSpentAmount = BigDecimal.valueOf(-randomGenerator.nextInt(100));
        int percentageDiscount = randomGenerator.nextInt(100);
        ValidationException validationException = null;

        // Test
        try {
            new CheckoutPromotion(id, minimumSpentAmount, percentageDiscount);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Result
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Minimum Amount Spent should be a positive number"));
    }

    @Test
    public void checkoutPromotionTestCreateObjectFailureNullMinimumSpend() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        String id = String.valueOf(randomGenerator.nextInt());
        BigDecimal minimumSpentAmount = null;
        int percentageDiscount = randomGenerator.nextInt(100);
        ValidationException validationException = null;

        // Test
        try {
            new CheckoutPromotion(id, minimumSpentAmount, percentageDiscount);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Result
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Minimum Amount Spent should be a positive number"));
    }
}
