package io.github.namuan.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroceryShopTest {

    GroceryShop groceryShop = new GroceryShop("Test Grocery Shop");

    @Test
    public void testCalculateCostForABasketWithNoItems() {
        // given
        Basket basket = new Basket();

        // when
        double basketCost = groceryShop.calculate(basket);

        // then
        assertEquals(0.0, basketCost);
    }

    @Test
    public void testCalculateCostForABasketWithASingleItem() {
        // given
        Basket basket = new Basket();
        basket.addItem(Product.SOUP, 1);

        // when
        double basketCost = groceryShop.calculate(basket);

        // then
        assertEquals(0.65, basketCost);
    }

}