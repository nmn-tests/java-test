package io.github.namuan;

import io.github.namuan.shop.*;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Henry's Grocery Shop
 */
public class App {
    public static void main(String[] args) {
        Console console = System.console();

        GroceryShop groceryShop = new GroceryShop("Henry's Grocery Shop");
        System.out.println(groceryShop);

        Basket basket = Basket.builder();

        List<String> productNames = Arrays.stream(Product.values()).map(Enum::name).collect(Collectors.toList());

        while(true) {
            System.out.println("Enter any items in the following list or \"checkout\" to calculate basket cost");
            System.out.println(String.join(",", productNames));

            String productEntry = console.readLine();

            if (productEntry.toLowerCase().equals("checkout")) {
                break;
            }

            System.out.println("Enter item quantity");
            String quantityEntry = console.readLine();

            try {
                BasketItem basketItem = InputReader.parseInput(productEntry, quantityEntry);
                basket.withItem(basketItem);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: Unable to parse input. Please check if you entered the correct product and quantity as a valid number");
            }
        }

        double basketCost = groceryShop.calculate(basket);
        System.out.println("Basket Total: " + basketCost);
    }
}
