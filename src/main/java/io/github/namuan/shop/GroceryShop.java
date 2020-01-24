package io.github.namuan.shop;

import io.github.namuan.promotion.HalfPriceLoafPromotion;
import io.github.namuan.promotion.Promotion;
import io.github.namuan.promotion.PromotionFactory;

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

        double discount = 0.0;

        for (Promotion promotion : availablePromotions()) {
            discount += promotion.apply(basket);
        }

        return roundOff(basketCost - discount);
    }

    private List<HalfPriceLoafPromotion> availablePromotions() {
        return PromotionFactory.availablePromotions();
    }

    private double roundOff(double input) {
        return new BigDecimal(input).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
