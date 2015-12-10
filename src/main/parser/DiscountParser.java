package main.parser;

import main.strategy.PromotionDiscount;
import main.strategy.PromotionStrategy;
import java.util.regex.Pattern;

/**
 * Created by lxw on 15-12-10.
 */
public class DiscountParser extends PromotionParser {
    private final Pattern PATTERN = Pattern.compile("^\\w+:\\d+$");

    @Override
    protected String getBarcode(String line) {
        String[] split = line.split(":");
        return split[0];
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }

    @Override
    protected PromotionStrategy getPromotionStrategy(String line) {
        String[] split = line.split(":");

        return new PromotionDiscount(Integer.parseInt(split[1]));
    }
}
