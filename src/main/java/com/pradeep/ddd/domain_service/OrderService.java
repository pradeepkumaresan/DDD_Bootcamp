package com.pradeep.ddd.domain_service;

import com.pradeep.ddd.domain.Cart;
import com.pradeep.ddd.domain.Item;
import com.pradeep.ddd.domain.Order;
import com.pradeep.ddd.domain.Product;

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
