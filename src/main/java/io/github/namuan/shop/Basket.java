package io.github.namuan.shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketItem> basketItems = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        BasketItem basketItem = new BasketItem(product, quantity);
        this.basketItems.add(basketItem);
    }

    public List<BasketItem> items() {
        return this.basketItems;
    }
}
