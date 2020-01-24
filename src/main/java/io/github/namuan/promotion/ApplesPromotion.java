package io.github.namuan.promotion;

import io.github.namuan.shop.Basket;
import io.github.namuan.shop.Product;
import io.github.namuan.shop.StockItems;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class ApplesPromotion implements Promotion {
    @Override
    public double apply(Basket basket) {
        int apples = getQuantityOfItemsInBasket(basket, Product.APPLE);
        if (apples < 1) {
            return 0.0;
        }
        double totalPrice = apples * StockItems.priceOf(Product.APPLE);
        return totalPrice * 10/100;
    }

    @Override
    public boolean isValid(LocalDate basketCreatedDate) {
        LocalDate from = LocalDate.now().plusDays(2);
        LocalDate to = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        return basketCreatedDate.isAfter(from) && basketCreatedDate.isBefore(to);
    }
}
