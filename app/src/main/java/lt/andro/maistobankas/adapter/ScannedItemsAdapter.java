package lt.andro.maistobankas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.base.Joiner;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.List;

import lt.andro.maistobankas.R;
import lt.andro.maistobankas.api.entity.Item;
import lt.andro.maistobankas.db.DatabaseHelper;
import lt.andro.maistobankas.db.ScannedItem;

/**
 * @author Vilius Kraujutis viliusk@gmail.com
 * @since 2014-02-08 16:02
 */
public class ScannedItemsAdapter extends BaseAdapter {
    private final Context context;
    private final List<ScannedItem> scannedItems;
    private final DatabaseHelper dbHelper;

    public ScannedItemsAdapter(Context context, List<ScannedItem> scannedItems, DatabaseHelper dbHelper) {
        this.context = context;
        this.scannedItems = scannedItems;
        this.dbHelper = dbHelper;
    }

    @Override
    public int getCount() {
        return scannedItems.size();
    }

    @Override
    public ScannedItem getItem(int position) {
        return scannedItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_scanned_item, parent, false);
        }

        final TextView titleView = (TextView) convertView.findViewById(R.id.row_scanned_item_title);
        final TextView barcodeView = (TextView) convertView.findViewById(R.id.row_scanned_item_barcode);
        final TextView infoView = (TextView) convertView.findViewById(R.id.row_scanned_item_info);
        final ImageView photoView = (ImageView) convertView.findViewById(R.id.row_scanned_item_photo);
        final ScannedItem scannedItem = getItem(position);
        try {
            final Item item = dbHelper.getItemDao().queryForId(scannedItem.getBarcode());
            if (item != null) {
                titleView.setText(item.getTitle());
                Picasso.with(context).load(item.getPhotoUrl()).into(photoView);

                final double price = item.getPrice();
                final double discount = item.getDiscount();
                final boolean isDiscount = item.isDiscount();
                String[] infoArray = new String[]{
                        item.getAmount(),
                        price > 0 ? price + " Lt" : null,
                        isDiscount ? String.format("-%.2f Lt", discount) : null
                };
                final String info = Joiner.on("; ").skipNulls().join(infoArray);
                infoView.setText(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        barcodeView.setText(scannedItem.getBarcode());

        return convertView;
    }
}
