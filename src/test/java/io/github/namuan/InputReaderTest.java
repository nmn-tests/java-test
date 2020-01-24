package io.github.namuan;

import io.github.namuan.shop.BasketItem;
import io.github.namuan.shop.InputReader;
import io.github.namuan.shop.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    @Test
    public void testCreateBasketItemFromInput() {
        // when
        BasketItem basketItem = InputReader.parseInput("apple", "1");

        // then
        assertEquals(Product.APPLE, basketItem.getProduct());
        assertEquals(1, basketItem.getQuantity());
    }

    @Test
    public void testThrowExceptionForInvalidProductInput() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputReader.parseInput("apps", "1");
        });
    }

    @Test
    public void testThrowExceptionForInvalidQuantityInput() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputReader.parseInput("apple", "abc");
        });
    }
}