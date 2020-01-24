package io.github.namuan.promotion;

import io.github.namuan.shop.Basket;
import io.github.namuan.shop.BasketItem;
import io.github.namuan.shop.Product;

import java.time.LocalDate;

public interface Promotion {
    double apply(Basket basket);

    boolean isValid(LocalDate basketCreatedDate);

    default int getQuantityOfItemsInBasket(Basket basket, Product product) {
        return basket
                .items()
                .stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .map(BasketItem::getQuantity)
                .orElse(0);
    }
}
