package com.pradeep.ddd;

import com.pradeep.ddd.domain.Cart;
import com.pradeep.ddd.domain.Item;
import com.pradeep.ddd.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void cartShouldContainOneItemWhenApplePencilIsAddedToCart() {
        Product applePencil = new Product("Apple Pencil");
        Item item =new Item(applePencil,1);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
    }

    @Test
    void cartShouldContainOneItemWhenSonyWirelessHeadphoneIsAddedToCart() {
        Product sonyWirelessHeadphone = new Product("Sony Wireless headphone");
        Item item =new Item(sonyWirelessHeadphone,1);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), sonyWirelessHeadphone);
    }
    @Test
    void cartShouldContainTwoItemsWhenTwoApplePencilsAreAddedToCart() {
        Product applePencil = new Product("Apple Pencil");
        Item item =new Item(applePencil,2);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 2);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
    }

    @Test
    void cartSizeShouldBeZeroWhenTheOnlyApplePencilItemIsRemoved() {
        Product applePencil = new Product("Apple Pencil");
        Item item =new Item(applePencil,1);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
        cart.remove(item);
        assertEquals(cart.getCartItems().size(), 0);
    }
    @Test
    void shouldReturnRemovedListWithApplePencilIfItIsRemovedFromCart() {
        Product applePencil = new Product("Apple Pencil");
        Item item =new Item(applePencil,1);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
        cart.remove(item);
        assertEquals(cart.getCartItems().size(), 0);
        assertEquals(cart.getRemovedProducts().get(0), applePencil);
    }
}