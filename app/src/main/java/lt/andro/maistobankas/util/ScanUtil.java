package lt.andro.maistobankas.util;

import android.support.v4.app.FragmentActivity;

import lt.andro.maistobankas.IntentIntegrator;
import lt.andro.maistobankas.R;

/**
 * @author Vilius Kraujutis viliusk@gmail.com
 * @since 2014-02-08 16:30
 */
public class ScanUtil {

    public static void initiateScan(FragmentActivity activity) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setMessage(activity.getString(R.string.barcode_scan_message));
        integrator.initiateScan();
    }

}
