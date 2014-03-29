package lt.andro.maistobankas.api;

import lt.andro.maistobankas.api.entity.ItemInfoResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * @since 2014-03-29 11:34
 */
public interface MainService {

    @GET("/cards/by-gtin/{gtin}?format=json")
    void getItemInfo(@Path("gtin") String globalTradeItemNumber, Callback<ItemInfoResponse> callback);
}
