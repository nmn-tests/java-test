package io.github.namuan.promotion;

import java.util.Arrays;
import java.util.List;

public class PromotionFactory {

    public static List<HalfPriceLoafPromotion> availablePromotions() {
        return Arrays.asList(new HalfPriceLoafPromotion());
    }
}
