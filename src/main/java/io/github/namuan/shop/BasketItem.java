package io.github.namuan.shop;

public class BasketItem {
    private final Product product;
    private final int quantity;

    public BasketItem(Product product, int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
