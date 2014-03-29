package lt.andro.maistobankas.api.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @since 2014-03-29 11:50
 */
@DatabaseTable(tableName = "items")
public class Item {

    /**
     * Global Trade Item Number
     */
    @DatabaseField(id = true)
    String gtin;
    @DatabaseField
    String title;
    @DatabaseField
    String photoUrl;
    @DatabaseField
    String amount;
    @DatabaseField
    boolean isDiscount;
    @DatabaseField
    double discount;
    @DatabaseField
    double price;

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
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
                .add("photoUrl", photoUrl)
                .add("amount", amount)
                .add("isDiscount", isDiscount)
                .add("discount", discount)
                .add("price", price)
                .add("gtin", gtin)
                .toString();
    }
}
