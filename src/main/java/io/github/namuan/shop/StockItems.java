package io.github.namuan.shop;

import java.util.HashMap;
import java.util.Map;

public class StockItems {
    private static Map<Product, Double> priceMap = new HashMap<>() {
        {
            put(Product.SOUP, 0.65);
            put(Product.BREAD, 0.80);
            put(Product.MILK, 1.30);
            put(Product.APPLE, 0.10);
        }
    };

    public static double priceOf(Product product) {
        if (!priceMap.containsKey(product)) {
            throw new IllegalArgumentException("Invalid Product: " + product);
        }

        return priceMap.get(product);
    }
}
