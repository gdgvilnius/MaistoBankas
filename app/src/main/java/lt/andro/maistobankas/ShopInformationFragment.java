package lt.andro.maistobankas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShopInformationFragment extends Fragment {

    private static final String SHARED_PREFERENCES_SHOP_INFORMATION = "shop_information.prefs";
    private static final String KEY_CITY = "sp.city";
    private static final String KEY_ADDRESS = "sp.address";
    private static final String KEY_SHOP_NAME = "sp.shop.name";
    private static final String KEY_PERSON_NAME = "sp.person.name";

    public ShopInformationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shop_information, container, false);

        final TextView cityView = (TextView) rootView.findViewById(R.id.editTextCity);
        final TextView addressView = (TextView) rootView.findViewById(R.id.editTextAddress);
        final TextView shopNameView = (TextView) rootView.findViewById(R.id.editTextShopName);
        final TextView personNameView = (TextView) rootView.findViewById(R.id.editTextName);
        final View saveButton = rootView.findViewById(R.id.buttonSaveInfo);

        fillForm(cityView, addressView, shopNameView, personNameView);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String city = cityView.getText().toString();
                final String address = addressView.getText().toString();
                final String shopName = shopNameView.getText().toString();
                final String personName = personNameView.getText().toString();

                final SharedPreferences sp = getActivity().getSharedPreferences(SHARED_PREFERENCES_SHOP_INFORMATION, Context.MODE_PRIVATE);

                sp.edit()
                        .putString(KEY_CITY, city)
                        .putString(KEY_ADDRESS, address)
                        .putString(KEY_SHOP_NAME, shopName)
                        .putString(KEY_PERSON_NAME, personName)
                        .commit();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new MainFragment())
                        .commit();
            }
        });


        return rootView;
    }

    private void fillForm(TextView cityView, TextView addressView, TextView shopNameView, TextView personNameView) {
        final SharedPreferences sp = getActivity().getSharedPreferences(SHARED_PREFERENCES_SHOP_INFORMATION, Context.MODE_PRIVATE);

        final String city = sp.getString(KEY_CITY, "");
        final String address = sp.getString(KEY_ADDRESS, "");
        final String shopName = sp.getString(KEY_SHOP_NAME, "");
        final String personName = sp.getString(KEY_PERSON_NAME, "");

        cityView.setText(city);
        addressView.setText(address);
        shopNameView.setText(shopName);
        personNameView.setText(personName);
    }
}












