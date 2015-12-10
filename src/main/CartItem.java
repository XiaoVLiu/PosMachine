package main;

/**
 * Created by lxw on 15-12-9.
 */
public class CartItem {
    private final String barcode;
    private final int quantity;

    public CartItem(String barcode, int quantity) {
        this.barcode = barcode;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getQuantity() {
        return quantity;
    }
}
