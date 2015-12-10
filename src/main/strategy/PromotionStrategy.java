package main.strategy;

/**
 * Created by lxw on 15-12-9.
 */
public interface PromotionStrategy {
    public double calculateSubTotal(int quantity, double subTotal);
}
