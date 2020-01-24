package io.github.namuan.promotion;

import io.github.namuan.shop.Basket;
import io.github.namuan.shop.Product;
import io.github.namuan.shop.StockItems;

import java.time.LocalDate;

public class HalfPriceLoafPromotion implements Promotion {
    @Override
    public double apply(Basket basket) {
        int soupTins = getQuantityOfItemsInBasket(basket, Product.SOUP);
        int breadLoaves = getQuantityOfItemsInBasket(basket, Product.BREAD);
        if (breadLoaves < 1 || soupTins < 2) {
            return 0.0;
        }

        return StockItems.priceOf(Product.BREAD) / 2;
    }

    @Override
    public boolean isValid(LocalDate basketCreatedDate) {
        LocalDate from = LocalDate.now().minusDays(2);
        LocalDate to = LocalDate.now().plusDays(8);
        return basketCreatedDate.isAfter(from) && basketCreatedDate.isBefore(to);
    }
}
