package main.parser;

import main.CartItem;

import java.util.regex.Pattern;

/**
 * Created by lxw on 15-12-9.
 */
public class CartParser extends Parser<CartItem> {
    private static final Pattern PATTERN = Pattern.compile("^\\w+-\\d+$");

    @Override
    protected CartItem parseLine(String line) {
        String[] splitString = line.split("-");
        String barcode = splitString[0];
        int quantity = Integer.parseInt(splitString[1]);

        return new CartItem(barcode, quantity);
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
