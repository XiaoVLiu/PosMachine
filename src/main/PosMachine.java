package main;

import java.util.List;

/**
 * Created by lxw on 15-12-9.
 */
public class PosMachine {
    private final List<Item> allItems;
    private final PromotionManager promotionManager;

    public PosMachine(final List<Item> allItems, PromotionManager promotionManager) {

        this.allItems = allItems;
        this.promotionManager = promotionManager;
    }

    public double calculate(final List<CartItem> cartItems) {
        double total = 0;

        for (CartItem cartItem : cartItems) {
            total += calculateSubTotal(cartItem);
        }

        return total;
    }

    private double calculateSubTotal(final CartItem cartItem) {
        String barcode = cartItem.getBarcode();
        double itemPrice = findItemPrice(barcode);

        return promotionManager.calculateTotalAfterPromotions(barcode, itemPrice, cartItem.getQuantity());
    }

    private double findItemPrice(final String barcode) {
        for (Item item : allItems) {
            if (item.getBarcode().equals(barcode)) {
                return item.getPrice();
            }
        }
        throw new IllegalArgumentException("unkown good item");
    }
}
