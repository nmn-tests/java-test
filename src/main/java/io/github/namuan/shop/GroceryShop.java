package io.github.namuan.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class GroceryShop {
    private String shopName;

    public GroceryShop(String shopName) {
        this.shopName = shopName;
    }

    public String toString() {
        return this.shopName;
    }

    public double calculate(Basket basket) {
        List<BasketItem> basketItems = basket.items();
        double basketCost = 0.0;

        for (BasketItem item : basketItems) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            basketCost += StockItems.priceOf(product) * quantity;
        }

        return roundOff(basketCost);
    }

    private double roundOff(double input) {
        return new BigDecimal(input).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
