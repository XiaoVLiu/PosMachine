package main.parser;

import main.Item;

import java.util.regex.Pattern;

/**
 * Created by lxw on 15-12-9.
 */
public class ItemParser extends Parser<Item> {
    private final Pattern PATTERN = Pattern.compile("^\\w+:\\d+$");

    @Override
    protected Item parseLine(String line) {
        String[] splitSting = line.split(":");
        String barcode = splitSting[0];
        double price = Double.parseDouble(splitSting[1]);

        return new Item(barcode, price);
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
