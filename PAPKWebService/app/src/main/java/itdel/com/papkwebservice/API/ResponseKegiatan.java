package itdel.com.papkwebservice.API;

import java.util.List;

import itdel.com.papkwebservice.model.Kegiatan;

/**
 * Created by Jayuk on 19/05/2017.
 */

public class ResponseKegiatan {
    private String error;
    public List<Kegiatan> listKegiatan;
    public String getError(){
        return error;
    }
    public void setError(String error)
    {
        this.error = error;
    }
    public List<Kegiatan> getListKegiatan()
    {
        return listKegiatan;
    }
    public void setListKegiatan(List<Kegiatan> listKegiatan)
    {
        this.listKegiatan = listKegiatan;
    }
}
