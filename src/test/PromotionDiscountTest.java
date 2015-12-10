package test;

import main.strategy.PromotionDiscount;
import main.strategy.PromotionStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lxw on 15-12-10.
 */
public class PromotionDiscountTest {

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionsWhenDiscountLessThanZero() {
        PromotionDiscount promotionDiscount = new PromotionDiscount(-1);
    }

    @Test
    public void testShouldReturnPriceAfterDiscountWhenOnlyOneGood() {
        PromotionStrategy promotionStrategy = new PromotionDiscount(50);

        assertEquals(promotionStrategy.calculateSubTotal(1, 100), 50, 1e-6);
    }

    @Test
    public void testShouldReturnSubtotalAfterDiscountWhenMultipleGoodsInput() {
        PromotionDiscount promotionDiscount = new PromotionDiscount(50);
        assertEquals(promotionDiscount.calculateSubTotal(5, 500), 250, 1e-6);
    }
}
