package com.pradeep.ddd;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> cartItems = new ArrayList<>();

    public void add(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }
}
