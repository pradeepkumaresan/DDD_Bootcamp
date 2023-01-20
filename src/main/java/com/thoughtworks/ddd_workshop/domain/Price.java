package com.thoughtworks.ddd_workshop.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {
    private BigDecimal amount;
    private Currency currency;

    public Price(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
