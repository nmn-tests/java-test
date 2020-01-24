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

class ApplesPromotionTest {

    ApplesPromotion applesPromotion = new ApplesPromotion();

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
                            LocalDate.now(),
                            INVALID
                    ),
                    Arguments.of(
                            LocalDate.now().plusDays(3),
                            VALID
                    ),
                    Arguments.of(
                            LocalDate.now().plusMonths(2),
                            INVALID
                    ),
                    Arguments.of(
                            LocalDate.now().plusWeeks(3),
                            VALID
                    )

            );
        }

    }

    @ParameterizedTest
    @ArgumentsSource(PromotionDatesProvider.class)
    public void testApplesPromotionValidityBasedOnDates(LocalDate basketCreatedDate, boolean isValid) {
        // when
        assertEquals(isValid, applesPromotion.isValid(basketCreatedDate));
    }

    @Test
    public void testThatNoDiscountIsAppliedIfNoApplesInBasket() {
        // given
        Basket basket = Basket.builder();

        // when
        double appliedDiscount = applesPromotion.apply(basket);

        // then
        assertEquals(0.0, appliedDiscount);
    }

    @Test
    public void testThatDiscountIsAppliedIfApplesInBasket() {
        // given
        Basket basket = Basket.builder().withItem(Product.APPLE, 10);

        // when
        double discountApplied = applesPromotion.apply(basket);

        // then
        assertEquals(0.1, discountApplied);
    }

}