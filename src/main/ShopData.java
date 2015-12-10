package main;

/**
 * Created by lxw on 15-12-9.
 */
import java.util.Arrays;
import java.util.List;

public final class ShopData {
    public static final List<String> ITEMS_DATA =
            Arrays.asList("ITEM000001:40", "ITEM000003:50", "ITEM000005:60");

    public static final List<String> SHOPPING_CART_DATA =
            Arrays.asList("ITEM000001-2", "ITEM000003-5", "ITEM000005-3");

    public static final List<String> DISCOUNT_ITEMS =
            Arrays.asList("ITEM000001:75", "ITEM000005:90");

    public static final List<String> SECOND_HALF_ITEMS =
            Arrays.asList("ITEM000001", "ITEM000003");

    public static final List<String> REDUCE_UPON_ITEMS =
            Arrays.asList("ITEM000005:reduce 30 upon 100");
}