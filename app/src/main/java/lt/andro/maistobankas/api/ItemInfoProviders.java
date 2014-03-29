package lt.andro.maistobankas.api;

/**
 * @since 2014-03-29 11:55
 */
public class ItemInfoProviders {
    private static final String SERVICES_ENDPOINT = "http://somedomain.com/";//TODO add real service endpoint

    public static String getServicesEndpoint() {
        return SERVICES_ENDPOINT;
    }
}
