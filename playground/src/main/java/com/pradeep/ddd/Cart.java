package com.pradeep.ddd;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products = new ArrayList<>();

    public void add(Product product){
        products.add(product);
    }

    public List<Product> getCartProducts(){
        return products;
    }
}
