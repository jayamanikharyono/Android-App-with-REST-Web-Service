package itdel.com.papkwebservice.API;

import java.util.List;

import itdel.com.papkwebservice.model.Fasilitas;

/**
 * Created by Jayuk on 22/05/2017.
 */

public class ResponseFasilitas {
    private String error;
    public List<Fasilitas> listFasilitas;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public List<Fasilitas> getListFasilitas()
    {
        return listFasilitas;
    }
    public void setListFasilitas(List<Fasilitas> listFasilitas)
    {
        this.listFasilitas = listFasilitas;
    }
}