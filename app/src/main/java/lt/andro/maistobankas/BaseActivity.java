package lt.andro.maistobankas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

/**
 * @author Vilius Kraujutis viliusk@gmail.com
 * @since 2014-02-08 12:23
 */
public class BaseActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MB", "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MB", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MB", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MB", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MB", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MB", "onDestroy");
    }
}
