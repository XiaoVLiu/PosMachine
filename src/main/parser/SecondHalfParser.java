package main.parser;

import main.strategy.PromotionSecondHalf;
import main.strategy.PromotionStrategy;

import java.util.regex.Pattern;

/**
 * Created by lxw on 15-12-10.
 */
public class SecondHalfParser extends PromotionParser {
    private static final Pattern PATTERN = Pattern.compile("^\\w+");

    @Override
    protected String getBarcode(String line) {
        return line;
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }

    @Override
    protected PromotionStrategy getPromotionStrategy(String line) {
        return new PromotionSecondHalf();
    }
}
