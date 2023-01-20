package com.pradeep.ddd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void cartShouldContainOneItemWhenApplePencilIsAddedToCart() {
        Product applePencil = new Product("Apple Pencil");
        CartItem cartItem=new CartItem(applePencil,1);
        Cart cart = new Cart();
        cart.add(cartItem);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
    }

    @Test
    void cartShouldContainOneItemWhenSonyWirelessHeadphoneIsAddedToCart() {
        Product sonyWirelessHeadphone = new Product("Sony Wireless headphone");
        CartItem cartItem=new CartItem(sonyWirelessHeadphone,1);
        Cart cart = new Cart();
        cart.add(cartItem);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), sonyWirelessHeadphone);
    }
    @Test
    void cartShouldContainTwoItemsWhenTwoApplePencilsAreAddedToCart() {
        Product applePencil = new Product("Apple Pencil");
        CartItem cartItem=new CartItem(applePencil,2);
        Cart cart = new Cart();
        cart.add(cartItem);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 2);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
    }
}