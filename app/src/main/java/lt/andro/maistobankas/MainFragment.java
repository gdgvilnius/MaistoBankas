package lt.andro.maistobankas;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.List;

import lt.andro.maistobankas.adapter.ScannedItemsAdapter;
import lt.andro.maistobankas.db.DatabaseHelper;
import lt.andro.maistobankas.db.ScannedItem;
import lt.andro.maistobankas.util.ScanUtil;

import static android.view.animation.AnimationUtils.loadAnimation;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        rootView.findViewById(R.id.buttonScan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentActivity activity = getActivity();
                ScanUtil.initiateScan(activity);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        final DatabaseHelper dbHelper = ((BaseActivity) getActivity()).getHelper();
        try {
            final List<ScannedItem> scannedItems = dbHelper.getScannedItemDao().queryForAll();
            showScannedItems(scannedItems);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        final View buttonScan = getView().findViewById(R.id.buttonScan);
        buttonScan.startAnimation(loadAnimation(getActivity(), R.anim.scan_button_show));
    }

    private void showScannedItems(List<ScannedItem> scannedItems) {
        if (getView() == null) {
            Log.e("MB", "view is null");
            return;
        }

        final ListView itemsList = (ListView) getView().findViewById(R.id.main_items_list);

        final FragmentActivity activity = getActivity();
        final DatabaseHelper helper = ((MainActivity) activity).getHelper();
        itemsList.setAdapter(new ScannedItemsAdapter(activity, scannedItems, helper));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new ShopInformationFragment())
                    .addToBackStack("Settings")
                    .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
