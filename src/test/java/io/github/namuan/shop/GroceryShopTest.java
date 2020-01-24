package io.github.namuan.shop;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static io.github.namuan.shop.Product.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GroceryShopTest {

    GroceryShop groceryShop = new GroceryShop("Test Grocery Shop");

    @ParameterizedTest
    @ArgumentsSource(BasketArgumentsProvider.class)
    public void testCalculateCostForABasket(Basket basket, double expectedBasketCode) {
        // when
        double basketCost = groceryShop.calculate(basket);

        // then
        assertEquals(expectedBasketCode, basketCost);
    }

    private static class BasketArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    // No Items
                    Arguments.of(
                            Basket.builder(),
                            0.0
                    ),
                    // Single Item
                    Arguments.of(
                            Basket.builder().withItem(Product.SOUP, 1),
                            0.65
                    ),
                    // All Available Items
                    Arguments.of(
                            Basket.builder()
                                    .withItem(APPLE, 1)
                                    .withItem(BREAD, 1)
                                    .withItem(MILK, 1)
                                    .withItem(SOUP, 1),
                            2.85
                    ),
                    // Half Bread Price Promotion
                    Arguments.of(
                            Basket.builder()
                                    .withItem(SOUP, 2)
                                    .withItem(BREAD, 1),
                            1.7
                    ),
                    // Apples Promotion
                    Arguments.of(
                            Basket.builder(LocalDate.now().plusDays(3))
                                    .withItem(APPLE, 5),
                            0.45
                    ),
                    // 3 tins of soup and 2 loaves of bread, bought today,
                    Arguments.of(
                            Basket.builder()
                                    .withItem(SOUP, 3)
                                    .withItem(BREAD, 2),
                            3.15
                    ),
                    // 6 apples and a bottle of milk, bought today
                    Arguments.of(
                            Basket.builder()
                                    .withItem(APPLE, 6)
                                    .withItem(MILK, 1),
                            1.90
                    ),
                    // 6 apples and a bottle of milk, bought in 5 days time
                    Arguments.of(
                            Basket.builder(LocalDate.now().plusDays(5))
                                    .withItem(APPLE, 6)
                                    .withItem(MILK, 1),
                            1.84
                    ),
                    // 2 tins of soup and a loaf of bread, bought in 5 days time
                    Arguments.of(
                            Basket.builder(LocalDate.now().plusDays(5))
                                    .withItem(APPLE, 3)
                                    .withItem(SOUP, 2)
                                    .withItem(BREAD, 1),
                            1.97
                    )

            );
        }

    }
}