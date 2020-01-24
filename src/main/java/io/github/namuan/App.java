package io.github.namuan;

import io.github.namuan.shop.GroceryShop;

/**
 * Henry's Grocery Shop
 */
public class App {
    public static void main(String[] args) {
        GroceryShop groceryShop = new GroceryShop("Henry's Grocery Shop");
        System.out.println(groceryShop);
    }
}
