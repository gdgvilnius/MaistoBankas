package lt.andro.maistobankas;

import android.app.Application;

import lt.andro.maistobankas.api.ItemInfoProviders;
import lt.andro.maistobankas.api.MainService;
import lt.andro.maistobankas.util.Utils;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * @since 2014-03-29 11:58
 */
public class MainApplication extends Application {
    public static MainService mainService;

    public MainApplication() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ItemInfoProviders.getServicesEndpoint())
                .setConverter(new GsonConverter(Utils.getGson()))
                .setLogLevel(RestAdapter.LogLevel.FULL).build();

        mainService = restAdapter.create(MainService.class);
    }
}
