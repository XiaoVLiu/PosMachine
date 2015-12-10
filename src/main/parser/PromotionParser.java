package main.parser;

import main.strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by lxw on 15-12-9.
 */
public abstract class PromotionParser {

    public Map<String, PromotionStrategy> parse(final List<String> input) {
        Map<String, PromotionStrategy> promotions = new HashMap<>();

        for (String line : input) {
            if (!getPattern().matcher(line).matches()) {
                throw new IllegalArgumentException("invalid promotion input!");
            }

            String barcode = getBarcode(line);
            PromotionStrategy promotionStrategy = getPromotionStrategy(line);

            promotions.put(barcode, promotionStrategy);
        }
        return promotions;
    }

    protected abstract String getBarcode(String line);

    protected abstract Pattern getPattern();

    protected abstract PromotionStrategy getPromotionStrategy(String line);
}
