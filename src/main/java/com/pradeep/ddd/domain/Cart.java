package com.pradeep.ddd.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();
    private final List<Product> removedProducts = new ArrayList<>();

    public void add(Item item){
        items.add(item);
    }

    public void remove(Item item){
        removedProducts.add(item.getProduct());
        items.remove(item);
    }

    public List<Item> getCartItems(){
        return items;
    }

    public List<Product> getRemovedProducts() {
        return removedProducts;
    }
}
