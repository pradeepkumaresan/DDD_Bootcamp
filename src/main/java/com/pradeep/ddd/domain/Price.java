package com.pradeep.ddd.domain;

import java.util.Currency;

public class Price {
    private final Currency price;

    public Price(Currency price) {
        this.price = price;
    }

    public Currency getPrice() {
        return price;
    }
}
