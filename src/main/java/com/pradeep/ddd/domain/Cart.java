package com.pradeep.ddd.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Cart {

    private final UUID id = UUID.randomUUID();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
