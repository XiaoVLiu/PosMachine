package main;

import main.strategy.PromotionStrategy;

import java.util.*;

/**
 * Created by lxw on 15-12-9.
 */
public class PromotionManager {
    private Map<String, List<PromotionStrategy>> promotionMap = new HashMap<>();

    public double calculateTotalAfterPromotions(final String barcode, double price, int quantity) {
        double subTotal = price * quantity;

        if (promotionMap.get(barcode)!=null) {
            for (PromotionStrategy promotionType : promotionMap.get(barcode)) {
                subTotal = promotionType.calculateSubTotal(quantity, subTotal);
            }
        }

        return subTotal;
    }

    public void addPromotion(Map<String, PromotionStrategy> promotion) {
        for (Map.Entry<String, PromotionStrategy> entry : promotion.entrySet()) {
            if (promotionMap.get(entry.getKey())==null) {
                promotionMap.put(entry.getKey(), new ArrayList<>(Arrays.asList(entry.getValue())));
            }
            else {
                PromotionStrategy strategy = entry.getValue();
                promotionMap.get(entry.getKey()).add(strategy);
            }
        }
    }
}
