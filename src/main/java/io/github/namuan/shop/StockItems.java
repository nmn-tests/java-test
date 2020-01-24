package io.github.namuan.shop;

public class StockItems {
    public static double priceOf(Product product) {
        if (product == Product.SOUP) {
            return 0.65;
        }

        return 0;
    }
}
