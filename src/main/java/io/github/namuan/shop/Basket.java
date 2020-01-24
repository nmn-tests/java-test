package io.github.namuan.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketItem> basketItems = new ArrayList<>();
    private LocalDate createdDate;

    public Basket() {
        this(LocalDate.now());
    }

    public Basket(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void addItem(Product product, int quantity) {
        BasketItem basketItem = new BasketItem(product, quantity);
        this.basketItems.add(basketItem);
    }

    public List<BasketItem> items() {
        return this.basketItems;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
