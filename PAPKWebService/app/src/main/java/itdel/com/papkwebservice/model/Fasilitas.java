package itdel.com.papkwebservice.model;

/**
 * Created by Jayuk on 19/05/2017.
 */

public class Fasilitas
{
    private int id;
    private String namaFasilitas;
    private String deskripsiFasilitas;

    public Fasilitas()
    {

    }

    public Fasilitas(int id, String namaFasilitas, String deskripsiFasilitas) {
        this.id = id;
        this.namaFasilitas = namaFasilitas;
        this.deskripsiFasilitas = deskripsiFasilitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaFasilitas() {
        return namaFasilitas;
    }

    public void setNamaFasilitas(String namaFasilitas) {
        this.namaFasilitas = namaFasilitas;
    }

    public String getDeskripsiFasilitas() {
        return deskripsiFasilitas;
    }

    public void setDeskripsiFasilitas(String deskripsiFasilitas) {
        this.deskripsiFasilitas = deskripsiFasilitas;
    }
}