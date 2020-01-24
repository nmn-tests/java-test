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

    @Test
    public void testCalculateCostForABasketWithMultipleItems() {
        // given
        Basket basket = new Basket();
        basket.addItem(Product.SOUP, 2);
        basket.addItem(Product.BREAD, 1);

        // when
        double basketCost = groceryShop.calculate(basket);

        // then
        assertEquals(2.1, basketCost);
    }

    @Test
    public void testCalculateCostForABasketWithAllAvailableProducts() {
        // given
        Basket basket = new Basket();
        basket.addItem(Product.BREAD, 1);
        basket.addItem(Product.SOUP, 1);
        basket.addItem(Product.APPLE, 1);
        basket.addItem(Product.MILK, 1);

        // when
        double basketCost = groceryShop.calculate(basket);

        // then
        assertEquals(2.85, basketCost);
    }

}