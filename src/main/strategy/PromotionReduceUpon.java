package main.strategy;

/**
 * Created by lxw on 15-12-10.
 */
public class PromotionReduceUpon implements PromotionStrategy {
    private final double reduceCondition;
    private final double reduceMoney;

    public PromotionReduceUpon(double reduceCondition, double reduceMoney) {
        this.reduceCondition = reduceCondition;
        this.reduceMoney = reduceMoney;
    }

    @Override
    public double calculateSubTotal(int quantity, double subTotal) {
        if (subTotal>=reduceCondition) {
            subTotal = subTotal - ((int)(subTotal/reduceCondition))*reduceMoney;
        }
        return subTotal;
    }
}
