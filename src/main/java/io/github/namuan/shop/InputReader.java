package io.github.namuan.shop;

public class InputReader {
    public static BasketItem parseInput(String productEntry, String quantityEntry) {
        Product product = Product.valueOf(productEntry.toUpperCase());
        int quantity = Integer.parseInt(quantityEntry);
        return new BasketItem(product, quantity);
    }
}
