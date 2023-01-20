package com.pradeep.ddd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void cartShouldContainOneItemWhenApplePencilIsAddedToCart() {
        Product applePencil = new Product("Apple Pencil");
        Cart cart = new Cart();
        cart.add(applePencil);
        assertEquals(cart.getCartProducts().size(), 1);
    }

    @Test
    void cartShouldContainOneItemWhenSonyWirelessHeadphoneIsAddedToCart() {
        Product applePencil = new Product("Sony Wireless headphone");
        Cart cart = new Cart();
        cart.add(applePencil);
        assertEquals(cart.getCartProducts().size(), 1);
    }
}