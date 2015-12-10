package main.parser;

import main.strategy.PromotionReduceUpon;
import main.strategy.PromotionStrategy;

import java.util.regex.Pattern;

/**
 * Created by lxw on 15-12-10.
 */
public class ReduceUponParser extends PromotionParser {
    private static final Pattern PATTERN = Pattern.compile("^\\w+:reduce \\d+ upon \\d+");

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
        String[] splitFirst = line.split(":");

        String[] split = splitFirst[1].split(" ");
        double reduceMoney = Double.parseDouble(split[1]);
        double reduceCodition = Double.parseDouble(split[3]);

        return new PromotionReduceUpon(reduceCodition, reduceMoney);
    }
}
