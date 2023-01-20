package com.pradeep.ddd.domain_service;

import java.math.BigDecimal;

public class DiscountCalculator {

    public static BigDecimal discountByTenPercent(BigDecimal amount){
        return amount.subtract(amount.multiply(new BigDecimal("0.1")));
    }
}
