package com.jamie.model;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class ProductTest {

    @Test
    public void productTestSucess() throws ValidationException {

        // Setup
        Random randomGenerator = new Random();
        String productId = UUID.randomUUID().toString();
        String productName = UUID.randomUUID().toString();
        BigDecimal productPrice = BigDecimal.valueOf(randomGenerator.nextDouble());

        // Test
        Product product = new Product(productId, productName, productPrice);

        // Results
        assertNotNull(product);
        assertThat(product.getId(), Is.is(productId));
        assertThat(product.getName(), Is.is(productName));
        assertThat(product.getPrice(), Is.is(productPrice));
    }

    @Test
    public void productTestSucessZeroPrice() throws ValidationException {

        // Setup
        String productId = UUID.randomUUID().toString();
        String productName = UUID.randomUUID().toString();
        BigDecimal productPrice = BigDecimal.valueOf(Double.parseDouble("0"));

        // Test
        Product product = new Product(productId, productName, productPrice);

        // Results
        assertNotNull(product);
        assertThat(product.getPrice(), Is.is(productPrice));
    }

    @Test
    public void productTestFailureNullId() throws ValidationException {

        // Setup
        ValidationException validationException = null;

        // Test
        try {
            new Product(null, "Travel Card Holder", BigDecimal.valueOf(Double.parseDouble("9.25")));
        } catch (ValidationException e){
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Item id must be not null or an empty"));
    }

    @Test
    public void productTestFailureEmptyId() throws ValidationException {

        // Setup
        ValidationException validationException = null;

        // Test
        try {
            new Product("", "Travel Card Holder", BigDecimal.valueOf(Double.parseDouble("9.25")));
        } catch (ValidationException e){
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Item id must be not null or an empty"));
    }

    @Test
    public void productTestFailureNullName() throws ValidationException {

        // Setup
        ValidationException validationException = null;

        // Test
        try {
            new Product("001", null, BigDecimal.valueOf(Double.parseDouble("9.25")));
        } catch (ValidationException e){
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Name of product must not be empty or null"));
    }

    @Test
    public void productTestFailureEmptyName() throws ValidationException {

        // Setup
        ValidationException validationException = null;

        // Test
        try {
            new Product("001", "", BigDecimal.valueOf(Double.parseDouble("9.25")));
        } catch (ValidationException e){
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Name of product must not be empty or null"));
    }

    @Test
    public void productTestFailureMinusPrice() throws ValidationException {

        // Setup
        ValidationException validationException = null;

        // Test
        try {
            new Product("001", "Travel Card Holder", BigDecimal.valueOf(Double.parseDouble("-19.25")));
        } catch (ValidationException e){
            validationException = e;
        }

        // Results
        assertNotNull(validationException);
        assertThat(validationException.getMessage(), Is.is("Price must be not be negative value"));
    }
}