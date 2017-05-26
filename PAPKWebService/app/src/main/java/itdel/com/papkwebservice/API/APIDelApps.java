package itdel.com.papkwebservice.API;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Jayuk on 19/05/2017.
 */

public interface APIDelApps {
    @POST("/kegiatan/all/")
    Call<ResponseKegiatan> getKegiatan();
    @POST("/fasilitas/all/")
    Call<ResponseFasilitas> getFasilitas();
    @POST("/deskripsi/all")
    Call<ArrayList<String>> getDeskripsi();
}
