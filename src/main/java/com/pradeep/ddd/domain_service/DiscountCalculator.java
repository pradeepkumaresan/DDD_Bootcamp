package com.pradeep.ddd.domain_service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {

    Map<String, BigDecimal> competitorPrices = new HashMap<>();

    public DiscountCalculator() {
        competitorPrices.put("Apple Pencil", new BigDecimal(75));
        competitorPrices.put("Sony Wireless headphone", new BigDecimal(100));
    }

    public static BigDecimal discountByTenPercent(BigDecimal amount){
        return amount.subtract(amount.multiply(new BigDecimal("0.1")));
    }
}
