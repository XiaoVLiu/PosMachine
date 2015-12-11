package test;

import main.parser.DiscountParser;
import main.parser.PromotionParser;
import main.parser.ReduceUponParser;
import main.parser.SecondHalfParser;
import main.strategy.PromotionStrategy;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lxw on 15-12-10.
 */
public class PromotionParserTest {
    private PromotionParser promotionParser;

    @Test
    public void testShouldParseOneDiscountPromotion() {
        promotionParser = new DiscountParser();
        Map<String, PromotionStrategy> promotionStrategyMap = promotionParser.parse(Arrays.asList("item001:75"));

        assertThat(promotionStrategyMap.size(), is(1));
        assertThat(promotionStrategyMap.get("item001").getClass().getName(), is("main.strategy.PromotionDiscount"));
    }

    @Test
    public void testShouldParseOneSecondHalfPromotion() {
        promotionParser = new SecondHalfParser();
        Map<String, PromotionStrategy> promotionStrategyMap = promotionParser.parse(Arrays.asList("item001"));

        assertThat(promotionStrategyMap.size(), is(1));
        assertThat(promotionStrategyMap.get("item001").getClass().getName(), is("main.strategy.PromotionSecondHalf"));
    }

    @Test
    public void testShouldParseOneReduceUponPromotion() {
        promotionParser = new ReduceUponParser();
        Map<String, PromotionStrategy> promotionStrategyMap = promotionParser.parse(Arrays.asList("item001:reduce 30 upon 100"));

        assertThat(promotionStrategyMap.size(), is(1));
        assertThat(promotionStrategyMap.get("item001").getClass().getName(), is("main.strategy.PromotionReduceUpon"));
    }
}
