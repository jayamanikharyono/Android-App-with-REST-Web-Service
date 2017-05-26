package itdel.com.papkwebservice.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jayuk on 19/05/2017.
 */

public class RESTClient {
    private static APIDelApps REST_CLIENT;
    static {
        setupRestClient();
    }
    private RESTClient(){}
    public static APIDelApps get()
    {
        return REST_CLIENT;
    }
    private static void setupRestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.238:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        REST_CLIENT = retrofit.create(APIDelApps.class);
    }

}
