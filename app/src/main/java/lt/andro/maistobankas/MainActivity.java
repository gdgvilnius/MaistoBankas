package lt.andro.maistobankas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.Date;

import lt.andro.maistobankas.api.entity.Item;
import lt.andro.maistobankas.db.ScannedItem;
import lt.andro.maistobankas.util.ScanUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null && resultCode == RESULT_OK) {
            final String barcode = scanResult.getContents();
            Toast.makeText(this, "ScanResult=" + barcode, Toast.LENGTH_LONG).show();
            final ScannedItem scannedItem = new ScannedItem();
            scannedItem.setBarcode(barcode);
            scannedItem.setPlace("Vilnius");
            scannedItem.setTime(new Date());
            scannedItem.setVolunteer("Vilius");

            Item item = null;

            try {
                item = getHelper().getItemDao().queryForId(barcode);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (item == null) {
                MainApplication.mainService.getItemInfo(barcode, new Callback<Item>() {
                    @Override
                    public void success(Item item, Response response) {
                        Log.d("MainActivity", item.toString());
                        try {
                            getHelper().getItemDao().create(item);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e("MainActivity", error.getMessage());
                    }
                });
            }

            try {
                getHelper().getScannedItemDao().create(scannedItem);
            } catch (SQLException e) {
                Log.e("MB", "Failed saving scanned Item.", e);
            }
            ScanUtil.initiateScan(this);
        }
    }
}
