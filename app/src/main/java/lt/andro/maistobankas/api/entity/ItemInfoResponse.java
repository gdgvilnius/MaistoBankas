package lt.andro.maistobankas.api.entity;

import java.util.Objects;

/**
 * @since 2014-03-29 11:50
 */
public class ItemInfoResponse {

    String title;
    String amount;
    boolean isDiscount;
    double discount;
    double price;
    /**
     * Global Trade Item Number
     */
    String gtin;

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }

    public String getGtin() {
        return gtin;
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("title", title)
                .add("amount", amount)
                .add("isDiscount", isDiscount)
                .add("discount", discount)
                .add("price", price)
                .add("gtin", gtin)
                .toString();
    }
}
