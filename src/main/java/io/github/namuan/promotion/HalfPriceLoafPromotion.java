package io.github.namuan.promotion;

import io.github.namuan.shop.Basket;
import io.github.namuan.shop.BasketItem;
import io.github.namuan.shop.Product;
import io.github.namuan.shop.StockItems;

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

    public int getQuantityOfItemsInBasket(Basket basket, Product product) {
        return basket
                .items()
                .stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .map(BasketItem::getQuantity)
                .orElse(0);
    }
}
