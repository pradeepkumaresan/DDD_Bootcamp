package com.thoughtworks.ddd_workshop.domain_service;

import com.thoughtworks.ddd_workshop.domain.Cart;
import com.thoughtworks.ddd_workshop.domain.Item;
import com.thoughtworks.ddd_workshop.domain.Order;
import com.thoughtworks.ddd_workshop.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OrderService {

    public Order create(Cart cart){
        List<Product> products = new ArrayList<>();
        for (Item item : cart.getCartItems()) {
            IntStream.range(0, item.getQuantity())
                    .mapToObj(i -> item.getProduct())
                    .forEach(products::add);
        }
        return new Order(products);
    }
}
