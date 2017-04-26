package com.jamie.TestData;


import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class TestData {

    public static BigDecimal generateTestProductPrice() throws ValidationException {
        Random random = new Random();
        double wholeNumber = random.nextInt(100);
        double decimalPlaces = round(random.nextDouble());
        BigDecimal productPrice = BigDecimal.valueOf(wholeNumber + decimalPlaces);
        return productPrice;
    }

    public static BigDecimal generateTestProductPriceDiscount(final BigDecimal originalPrice) throws ValidationException {
        Random random = new Random();
        double wholeNumber = random.nextInt(originalPrice.intValue());
        double decimalPlaces = round(random.nextDouble());
        BigDecimal productPrice = BigDecimal.valueOf(wholeNumber + decimalPlaces);
        return productPrice;
    }

    public static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
