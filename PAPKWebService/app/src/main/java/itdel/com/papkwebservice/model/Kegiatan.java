package itdel.com.papkwebservice.model;

/**
 * Created by Jayuk on 19/05/2017.
 */

public class Kegiatan
{
    private int id;
    private String namaKegiatan;
    private String deskripsiKegiatan;

    public Kegiatan()
    {

    }

    public Kegiatan(int id, String namaKegiatan, String deskripsiKegiatan) {
        this.id = id;
        this.namaKegiatan = namaKegiatan;
        this.deskripsiKegiatan = deskripsiKegiatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String getDeskripsiKegiatan() {
        return deskripsiKegiatan;
    }

    public void setDeskripsiKegiatan(String deskripsiKegiatan) {
        this.deskripsiKegiatan = deskripsiKegiatan;
    }
}
