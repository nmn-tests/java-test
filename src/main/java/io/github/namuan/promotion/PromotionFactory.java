package io.github.namuan.promotion;

import java.util.Arrays;
import java.util.List;

public class PromotionFactory {

    public static List<Promotion> availablePromotions() {
        return Arrays.asList(new HalfPriceLoafPromotion(), new ApplesPromotion());
    }
}
