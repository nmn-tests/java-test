package io.github.namuan.promotion;

import io.github.namuan.shop.Basket;
import io.github.namuan.shop.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HalfPriceLoafPromotionTest {

    HalfPriceLoafPromotion halfPriceLoafPromotion = new HalfPriceLoafPromotion();

    private static class PromotionDatesProvider implements ArgumentsProvider {

        private static final boolean VALID = true;
        private static final boolean INVALID = false;

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(
                            LocalDate.now().minusDays(2),
                            INVALID
                    ),
                    Arguments.of(
                            LocalDate.now().minusDays(1),
                            VALID
                    ),
                    Arguments.of(
                            LocalDate.now(),
                            VALID
                    ),
                    Arguments.of(
                            LocalDate.now().plusDays(7),
                            VALID
                    ),
                    Arguments.of(
                            LocalDate.now().plusDays(8),
                            INVALID
                    )

            );
        }

    }

    @ParameterizedTest
    @ArgumentsSource(PromotionDatesProvider.class)
    public void testPromotionValidityBasedOnDates(LocalDate basketCreatedDate, boolean isValid) {
        // when
        assertEquals(isValid, halfPriceLoafPromotion.isValid(basketCreatedDate));
    }

    @Test
    public void testThatNoDiscountIsAppliedIfNoItemsInBasket() {
        // given
        Basket basket = Basket.builder();

        // when
        double appliedDiscount = halfPriceLoafPromotion.apply(basket);

        // then
        assertEquals(0.0, appliedDiscount);
    }

    @Test
    public void testThatNoDiscountIsAppliedIfNotEnoughApplesOrBreadInBasket() {
        // given
        Basket basket = Basket.builder();
        basket.withItem(Product.APPLE, 2);

        // when
        double appliedDiscount = halfPriceLoafPromotion.apply(basket);

        // then
        assertEquals(0.0, appliedDiscount);
    }

    @Test
    public void testThatDiscountIsAppliedIfApplicableForItemsInBasket() {
        // given
        Basket basket = Basket.builder().withItem(Product.SOUP, 2).withItem(Product.BREAD, 1);

        // when
        double discountApplied = halfPriceLoafPromotion.apply(basket);

        // then
        assertEquals(0.4, discountApplied);
    }

}