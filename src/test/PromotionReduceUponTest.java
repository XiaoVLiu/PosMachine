package test;

import main.strategy.PromotionReduceUpon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lxw on 15-12-10.
 */
public class PromotionReduceUponTest {
    private PromotionReduceUpon promotionReduceUpon;

    @Before
    public void setUp() {
        promotionReduceUpon = new PromotionReduceUpon(100, 30);
    }

    @Test
    public void testShouldReturnOriginalMoneyWhenSubtotalLessThanReduceCondition() {
        assertEquals(promotionReduceUpon.calculateSubTotal(1, 90), 90, 1e-6);
    }

    @Test
    public void testShouldReturnSubtotalAfterReduceWhenOriginalSubtotalEqualToReduceCondition() {
        assertEquals(promotionReduceUpon.calculateSubTotal(1, 100), 70, 1e-6);
    }

    @Test
    public void testShouldReturnSubtotalAfterReduceWhenOriginalSubtotalMoreThanReduceCondition() {
        assertEquals(promotionReduceUpon.calculateSubTotal(1, 450), 330, 1e-6);

    }
}
