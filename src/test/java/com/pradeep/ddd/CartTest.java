package com.pradeep.ddd;

import com.pradeep.ddd.domain_service.DiscountService;
import com.pradeep.ddd.domain.Cart;
import com.pradeep.ddd.domain.Item;
import com.pradeep.ddd.domain.Price;
import com.pradeep.ddd.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void cartShouldContainOneItemWhenApplePencilIsAddedToCart() {
        Product applePencil = new Product("Apple Pencil",
                new Price(new BigDecimal(30), Currency.getInstance("USD")));
        Item item =new Item(applePencil,1);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
    }

    @Test
    void cartShouldContainOneItemWhenSonyWirelessHeadphoneIsAddedToCart() {
        Product sonyWirelessHeadphone = new Product("Sony Wireless headphone",
                new Price(new BigDecimal(40), Currency.getInstance("USD")));
        Item item =new Item(sonyWirelessHeadphone,1);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), sonyWirelessHeadphone);
    }
    @Test
    void cartShouldContainTwoItemsWhenTwoApplePencilsAreAddedToCart() {
        Product applePencil = new Product("Apple Pencil",
                new Price(new BigDecimal(30), Currency.getInstance("USD")));
        Item item =new Item(applePencil,2);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 2);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
    }

    @Test
    void cartSizeShouldBeZeroWhenTheOnlyApplePencilItemIsRemoved() {
        Product applePencil = new Product("Apple Pencil",
                new Price(new BigDecimal(30), Currency.getInstance("USD")));
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
        Product applePencil = new Product("Apple Pencil",
                new Price(new BigDecimal(30), Currency.getInstance("USD")));
        Item item =new Item(applePencil,1);
        Cart cart = new Cart();
        cart.add(item);
        assertEquals(cart.getCartItems().get(0).getQuantity(), 1);
        assertEquals(cart.getCartItems().get(0).getProduct(), applePencil);
        cart.remove(item);
        assertEquals(cart.getCartItems().size(), 0);
        assertEquals(cart.getRemovedProducts().get(0), applePencil);
    }

    @Test
    void shouldReturnFalseIfTwoCartsHavingSameItemsComparedWithEachOther() {
        Product applePencil = new Product("Apple Pencil",
                new Price(new BigDecimal(30), Currency.getInstance("USD")));
        Item item = new Item(applePencil, 1);
        Cart cart = new Cart();
        cart.add(item);

        Product anotherApplePencil = new Product("Apple Pencil",
                new Price(new BigDecimal(30), Currency.getInstance("USD")));
        Item anotherApplePencilItem = new Item(anotherApplePencil, 1);
        Cart anotherCart = new Cart();
        anotherCart.add(anotherApplePencilItem);

        assertNotEquals(cart, anotherCart);
    }

    @Test
    void productPriceShouldBeTenPercentBelowCompetitorPrice() {
        BigDecimal discountedAmount = DiscountService
                .discountByTenPercent(DiscountService.getCompetitorPrices().get("Apple Pencil"));
        Product applePencil = new Product("Apple Pencil",
                new Price(discountedAmount,
                        Currency.getInstance("USD")));

        assertEquals(discountedAmount, applePencil.getPrice().getAmount());
    }
}