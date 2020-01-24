package io.github.namuan.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockItemsTest {

    @Test
    public void testCheckPriceForAnKnownProduct() {
        // when, then
        assertEquals(0.80, StockItems.priceOf(Product.BREAD));
    }

    @Test
    public void testThrowsExceptionWhenCheckingPriceForAnUnknownProduct() {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StockItems.priceOf(Product.WATER);
        });
    }

}