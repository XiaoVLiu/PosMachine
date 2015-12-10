package main.strategy;

/**
 * Created by lxw on 15-12-10.
 */
public class PromotionDiscount implements PromotionStrategy {
    private final double discount;

    public PromotionDiscount(int discount) {
        if (discount<0) {
            throw new IllegalArgumentException("discount ration cannot less than zero!");
        }

        this.discount = discount/100d;
    }

    @Override
    public double calculateSubTotal(int quantity, double subTotal) {
        return discount * subTotal;
    }
}
