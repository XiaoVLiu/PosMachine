package main.strategy;

/**
 * Created by lxw on 15-12-10.
 */
public class PromotionSecondHalf implements PromotionStrategy {
    @Override
    public double calculateSubTotal(int quantity, double subTotal) {
        double curPrice = subTotal/(double)quantity;

        return subTotal - (curPrice/2d)*(quantity/2);
    }
}
