package lt.andro.maistobankas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.Date;

import lt.andro.maistobankas.db.ScannedItem;

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
        if (scanResult != null) {
            final String barcode = scanResult.getContents();
            Toast.makeText(this, "ScanResult=" + barcode, Toast.LENGTH_LONG).show();
            final ScannedItem scannedItem = new ScannedItem();
            scannedItem.setBarcode(barcode);
            scannedItem.setPlace("Vilnius");
            scannedItem.setTime(new Date());
            scannedItem.setVolunteer("Vilius");

            try {
                getHelper().getScannedItemDao().create(scannedItem);
            } catch (SQLException e) {
                Log.e("MB", "Failed saving scanned Item.", e);
            }
//            // you get the SQLiteOpenHelper from your Android Activity
//            ConnectionSource connectionSource =
//                    new AndroidConnectionSource(get);
//
//// instantiate the DAO to handle Account with String id
//            Dao<Account,String> accountDao =
//                    BaseDaoImpl.createDao(connectionSource, Account.class);
//
//// if you need to create the 'accounts' table make this call
//            TableUtils.createTable(connectionSource, Account.class);
//
//// create an instance of Account
//            String name = "Jim Smith";
//            Account account = new Account(name, "_secret");
//
//// persist the account object to the database
//// it should return 1 for the 1 row inserted
//            if (accountDao.create(account) != 1) {
//                throw new Exception("Failure adding account");
//            }
//
//// retrieve the account
//            Account account2 = accountDao.queryForId(name);
//// show its password
//            System.out.println("Account: " + account2.getPassword());
//
//// close the connection source
//            connectionSource.close();
//            // TODO save scan result into database
        }
        // else continue with any other code you need in the method
    }
}
