    package lt.andro.maistobankas.util;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    /**
     * @since 2014-03-29 12:23
     */
    public class Utils {
        private static Gson gson;

        public static Gson getGson() {
            if (gson == null) {
                gson = new GsonBuilder().create();
            }
            return gson;
        }
    }
