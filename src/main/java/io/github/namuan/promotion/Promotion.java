package io.github.namuan.promotion;

import io.github.namuan.shop.Basket;

public interface Promotion {
    double apply(Basket basket);
}
