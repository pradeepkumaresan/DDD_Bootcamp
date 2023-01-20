package com.thoughtworks.ddd_workshop.domain_service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DiscountService {

    private static final Map<String, BigDecimal> competitorPrices = new HashMap<>();

    static {
        competitorPrices.put("Apple Pencil", new BigDecimal(75));
        competitorPrices.put("Sony Wireless headphone", new BigDecimal(100));
    }

    public static Map<String, BigDecimal> getCompetitorPrices(){
        return competitorPrices;
    }

    public static BigDecimal discountByTenPercent(BigDecimal amount){
        return amount.subtract(amount.multiply(new BigDecimal("0.1")));
    }
}
