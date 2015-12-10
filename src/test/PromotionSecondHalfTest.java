package test;

import main.strategy.PromotionSecondHalf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lxw on 15-12-10.
 */
public class PromotionSecondHalfTest {
    private final PromotionSecondHalf promotionSecondHalf = new PromotionSecondHalf();
    @Test
    public void testShouldReturnOriginalSubtotalWhenQuantityLessThanTwo() {
        assertEquals(promotionSecondHalf.calculateSubTotal(1, 100), 100, 1e-6);
    }

    @Test
    public void testShouldReturnSubtotalWhenQuantityEqualToTwo() {
        assertEquals(promotionSecondHalf.calculateSubTotal(2, 200), 150, 1e-6);
    }

    @Test
    public void testShouldReturnSubtotalWhenOddQuantityMoreThanTwo() {
        assertEquals(promotionSecondHalf.calculateSubTotal(5, 500), 400, 1e-6);
    }

    @Test
    public void testShouldReturnSubtotalWhenEvenQuantityMoreThanTwo() {
        assertEquals(promotionSecondHalf.calculateSubTotal(6, 600), 450, 1e-6);
    }
}
