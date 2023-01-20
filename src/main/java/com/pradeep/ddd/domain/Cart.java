package com.pradeep.ddd.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cart {

    private final UUID id = UUID.randomUUID();
    private final List<Item> items = new ArrayList<>();
    private final List<Product> removedProducts = new ArrayList<>();

    private boolean checkedOut = false;

    public void add(Item item){
        items.add(item);
    }

    public void remove(Item item){
        removedProducts.add(item.getProduct());
        items.remove(item);
    }

    public Order checkOut(){
        List<Product> products = new ArrayList<>();
        for (Item item : items) {
            IntStream.range(0, item.getQuantity())
                    .mapToObj(i -> item.getProduct())
                    .forEach(products::add);
        }
        checkedOut = true;
        return new Order(products);
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
