package lt.andro.maistobankas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lt.andro.maistobankas.R;
import lt.andro.maistobankas.db.ScannedItem;

/**
 * @author Vilius Kraujutis viliusk@gmail.com
 * @since 2014-02-08 16:02
 */
public class ScannedItemsAdapter extends BaseAdapter {
    private final Context context;
    private final List<ScannedItem> scannedItems;

    public ScannedItemsAdapter(Context context, List<ScannedItem> scannedItems) {
        this.context = context;
        this.scannedItems = scannedItems;
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

        final TextView barcodeView = (TextView) convertView.findViewById(R.id.row_scanned_item_barcode);
        final ScannedItem item = getItem(position);
        barcodeView.setText(item.getBarcode());
        return convertView;
    }
}
