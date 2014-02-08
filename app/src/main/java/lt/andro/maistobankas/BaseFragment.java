package lt.andro.maistobankas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Vilius Kraujutis viliusk@gmail.com
 * @since 2014-02-08 13:04
 */
public class BaseFragment extends Fragment {
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("MBBaseFragment", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MBBaseFragment", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("MBBaseFragment", "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MBBaseFragment", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MBBaseFragment", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MBBaseFragment", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("MBBaseFragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("MBBaseFragment", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MBBaseFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MBBaseFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("MBBaseFragment", "onDetach");
    }
}
