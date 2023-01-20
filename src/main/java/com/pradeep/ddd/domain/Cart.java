package com.pradeep.ddd.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item){
        items.add(item);
    }

    public List<Item> getCartItems(){
        return items;
    }
}
