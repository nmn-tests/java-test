package io.github.namuan.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketItem> basketItems = new ArrayList<>();
    private LocalDate createdDate;

    private Basket() {
        this(LocalDate.now());
    }

    private Basket(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Basket withItem(Product product, int quantity) {
        BasketItem basketItem = new BasketItem(product, quantity);
        this.basketItems.add(basketItem);
        return this;
    }

    public List<BasketItem> items() {
        return this.basketItems;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public static Basket builder() {
        return new Basket();
    }

    public static Basket builder(LocalDate createdDate) {
        return new Basket(createdDate);
    }

}
