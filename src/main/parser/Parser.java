package main.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by lxw on 15-12-9.
 */
public abstract class Parser<T> {
    public List<T> parse(final List<String> input) {
        List<T> list = new ArrayList<>();

        for (String line : input) {
            validateInput(line);
            list.add(parseLine(line));
        }
        return list;
    }

    protected abstract T parseLine(final String line);

    private void validateInput(final String line) {
        if (!getPattern().matcher(line).matches()) {
            throw new IllegalArgumentException("invalid input!");
        }
    }

    protected abstract Pattern getPattern();
}
