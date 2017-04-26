package com.jamie.model.promotions;

import com.jamie.TestData.TestData;
import org.hamcrest.core.Is;
import org.junit.Test;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.*;

public class ProductPromotionTest {

    @Test
    public void productPromotionTestCreateObjectSuccess() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        String productId = String.valueOf(random.nextInt());
        BigDecimal productCurrentPrice = TestData.generateTestProductPrice();
        int amountRequiredForPromotion = random.nextInt(10) + 1;
        BigDecimal newProductPrice = TestData.generateTestProductPriceDiscount(productCurrentPrice);

        // Test
        ProductPromotion productPromotion = new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);

        // Results
        assertNotNull(productPromotion);
        assertThat(productPromotion.getAmountRequiredForPromotion(), Is.is(amountRequiredForPromotion));
        assertThat(productPromotion.getNewProductPrice(), Is.is(newProductPrice));
        assertThat(productPromotion.getProductId(), Is.is(productId));
    }

    @Test
    public void productPromotionTestCreateObjectSuccessZeroAmountRequired() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        String productId = String.valueOf(random.nextInt());
        BigDecimal productCurrentPrice = TestData.generateTestProductPrice();
        int amountRequiredForPromotion = 0;
        BigDecimal newProductPrice = TestData.generateTestProductPriceDiscount(productCurrentPrice);

        // Test
        ProductPromotion productPromotion = new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);

        // Results
        assertNotNull(productPromotion);
        assertThat(productPromotion.getId(), Is.is(id));
        assertThat(productPromotion.getAmountRequiredForPromotion(), Is.is(amountRequiredForPromotion));
        assertThat(productPromotion.getNewProductPrice(), Is.is(newProductPrice));
        assertThat(productPromotion.getProductId(), Is.is(productId));
    }

    @Test
    public void productPromotionTestCreateObjectFailureNullId() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = null;
        String productId = String.valueOf(random.nextInt());
        BigDecimal productCurrentPrice = TestData.generateTestProductPrice();
        int amountRequiredForPromotion = 0;
        BigDecimal newProductPrice = TestData.generateTestProductPriceDiscount(productCurrentPrice);
        ValidationException validationException = null;

        // Test
        try {
            new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Id can not be null"));
    }

    @Test
    public void productPromotionTestCreateObjectFailureEmptyId() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = "";
        String productId = String.valueOf(random.nextInt());
        BigDecimal productCurrentPrice = TestData.generateTestProductPrice();
        int amountRequiredForPromotion = 0;
        BigDecimal newProductPrice = TestData.generateTestProductPriceDiscount(productCurrentPrice);
        ValidationException validationException = null;

        // Test
        try {
            new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Id can not be null"));
    }

    @Test
    public void productPromotionTestCreateObjectFailureNullProductId() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        String productId = null;
        BigDecimal productCurrentPrice = TestData.generateTestProductPrice();
        int amountRequiredForPromotion = 0;
        BigDecimal newProductPrice = TestData.generateTestProductPriceDiscount(productCurrentPrice);
        ValidationException validationException = null;

        // Test
        try {
            new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("ProductId can not be null or empty"));
    }

    @Test
    public void productPromotionTestCreateObjectFailureProductId() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        String productId = "";
        BigDecimal productCurrentPrice = TestData.generateTestProductPrice();
        int amountRequiredForPromotion = 0;
        BigDecimal newProductPrice = TestData.generateTestProductPriceDiscount(productCurrentPrice);
        ValidationException validationException = null;

        // Test
        try {
            new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("ProductId can not be null or empty"));
    }

    @Test
    public void productPromotionTestCreateObjectFailureMinusAmountRequiredForPromotion() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        String productId = String.valueOf(random.nextInt());
        int amountRequiredForPromotion = 0;
        BigDecimal newProductPrice = BigDecimal.valueOf(-1);
        ValidationException validationException = null;

        // Test
        try {
            new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Price must be more than zero"));
    }

    @Test
    public void productPromotionTestCreateObjectFailureMinusNewProductPrice() throws ValidationException {

        // Setup
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        String productId = String.valueOf(random.nextInt());
        BigDecimal productCurrentPrice = TestData.generateTestProductPrice();
        int amountRequiredForPromotion = -1;
        BigDecimal newProductPrice = TestData.generateTestProductPriceDiscount(productCurrentPrice);
        ValidationException validationException = null;

        // Test
        try {
            new ProductPromotion(id, productId, amountRequiredForPromotion, newProductPrice);
        } catch (ValidationException e) {
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("For a product promotion please select how many purchases are required before promotion is valid"));
    }
}