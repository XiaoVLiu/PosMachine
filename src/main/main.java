package main;

import main.parser.*;
import java.util.List;


/**
 * Created by lxw on 15-12-9.
 */
public class main {
    public static void main(String[] args) {
        ItemParser itemParser = new ItemParser();
        List<Item> allItems = itemParser.parse(ShopData.ITEMS_DATA);

        CartParser cartParser = new CartParser();
        List<CartItem> cartItems = cartParser.parse(ShopData.SHOPPING_CART_DATA);

        PromotionManager promotionManager = new PromotionManager();
        DiscountParser discountParser = new DiscountParser();
        promotionManager.addPromotion(discountParser.parse(ShopData.DISCOUNT_ITEMS));

        SecondHalfParser secondHalfParser = new SecondHalfParser();
        promotionManager.addPromotion(secondHalfParser.parse(ShopData.SECOND_HALF_ITEMS));

        ReduceUponParser reduceUponParser = new ReduceUponParser();
        promotionManager.addPromotion(reduceUponParser.parse(ShopData.REDUCE_UPON_ITEMS));

        PosMachine posMachine = new PosMachine(allItems, promotionManager);

        System.out.println("总价："+posMachine.calculate(cartItems));
    }
}
