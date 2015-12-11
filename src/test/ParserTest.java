package test;

import main.parser.*;
import main.Item;
import main.strategy.PromotionStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by lxw on 15-12-9.
 */
public class ParserTest {
    private ItemParser itemParser;
    private CartParser cartParser;

    @Before
    public void setUp() {
        itemParser = new ItemParser();
        cartParser = new CartParser();
    }

    @Test
    public void testShouldGetEmptyItemWhenGivenNone() {
        List<Item> items = itemParser.parse(asList());
        List<Item> expectedItems = asList();

        assertThat(items, is(expectedItems));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldCheckInvalidInputSuccessfully() {
        itemParser.parse(asList("invalid input"));
        cartParser.parse(asList("invalid:input"));
    }

    @Test
    public void testShouleGetOneGoodSuccessfully() {
        List<Item> items = itemParser.parse(asList("01:20"));
        assertThat(items.get(0).getBarcode(), is("01"));
        assertEquals(items.get(0).getPrice(), 20, 1e-6);
    }

    @Test
    public void testShouldGetMultipleGoodsSuccessfully() {
        List<Item> items = itemParser.parse(asList("01:20", "02:30", "03:40"));

        assertThat(items.get(0).getBarcode(), is("01"));
        assertThat(items.get(1).getBarcode(), is("02"));
        assertThat(items.get(2).getBarcode(), is("03"));

        assertEquals(items.get(0).getPrice(), 20, 1e-6);
        assertEquals(items.get(1).getPrice(), 30, 1e-6);
        assertEquals(items.get(2).getPrice(), 40, 1e-6);
    }
}
