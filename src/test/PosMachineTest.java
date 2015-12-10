package test;

import main.*;
import main.parser.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PosMachineTest {
    private PosMachine posMachine;
    private PromotionManager promotionManager;

    @Before
    public void setUp() {
        ItemParser itemParser = new ItemParser();
        List<Item> allItems = itemParser.parse(ShopData.ITEMS_DATA);

        promotionManager = new PromotionManager();
        posMachine = new PosMachine(allItems, promotionManager);
    }

    @Test
    public void testShouldReturnZeroWhenCartEmpty() {
        List<CartItem> emptyCart = Arrays.asList();
        double total = posMachine.calculate(emptyCart);

        assertEquals(total, 0, 1e-6);
    }

    @Test
    public void testShouldReturnOriginalTotalWhenNonePromotions() {
        CartParser cartParser = new CartParser();
        List<CartItem> cartItems = cartParser.parse(ShopData.SHOPPING_CART_DATA);

        assertEquals(posMachine.calculate(cartItems), 510, 1e-6);
    }

    @Test
    public void testShouldReturnTotalMoneyAfterDiscount() {
        CartParser cartParser = new CartParser();
        List<CartItem> cartItems = cartParser.parse(ShopData.SHOPPING_CART_DATA);

        DiscountParser discountParser = new DiscountParser();
        promotionManager.addPromotion(discountParser.parse(ShopData.DISCOUNT_ITEMS));

        assertEquals(posMachine.calculate(cartItems), 472, 1e-6);
    }

    @Test
    public void testShouldReturnTotalMoneyAfterSecondHalf() {
        CartParser cartParser = new CartParser();
        List<CartItem> cartItems = cartParser.parse(ShopData.SHOPPING_CART_DATA);

        SecondHalfParser secondHalfParser = new SecondHalfParser();
        promotionManager.addPromotion(secondHalfParser.parse(ShopData.SECOND_HALF_ITEMS));

        assertEquals(posMachine.calculate(cartItems), 440, 1e-6);
    }

    @Test
    public void testShouldReturnTotalMoneyAfterReduceUpon() {
        CartParser cartParser = new CartParser();
        List<CartItem> cartItems = cartParser.parse(ShopData.SHOPPING_CART_DATA);

        ReduceUponParser reduceUponParser = new ReduceUponParser();
        promotionManager.addPromotion(reduceUponParser.parse(ShopData.REDUCE_UPON_ITEMS));

        assertEquals(posMachine.calculate(cartItems), 480, 1e-6);
    }

    @Test
    public void testShouldReturnTotalMoneyAfterAllPromotions() {
        CartParser cartParser = new CartParser();
        List<CartItem> cartItems = cartParser.parse(ShopData.SHOPPING_CART_DATA);

        DiscountParser discountParser = new DiscountParser();
        promotionManager.addPromotion(discountParser.parse(ShopData.DISCOUNT_ITEMS));

        SecondHalfParser secondHalfParser = new SecondHalfParser();
        promotionManager.addPromotion(secondHalfParser.parse(ShopData.SECOND_HALF_ITEMS));

        ReduceUponParser reduceUponParser = new ReduceUponParser();
        promotionManager.addPromotion(reduceUponParser.parse(ShopData.REDUCE_UPON_ITEMS));

        assertEquals(posMachine.calculate(cartItems), 377, 1e-6);

    }
}
