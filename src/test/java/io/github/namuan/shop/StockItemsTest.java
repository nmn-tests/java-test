package io.github.namuan.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockItemsTest {

    @Test
    public void testCheckPriceForAnKnownProduct() {
        // when, then
        assertEquals(0.80, StockItems.priceOf(Product.BREAD));
    }

}