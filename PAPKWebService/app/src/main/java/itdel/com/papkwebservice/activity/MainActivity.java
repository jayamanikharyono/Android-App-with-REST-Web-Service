package itdel.com.papkwebservice.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import itdel.com.papkwebservice.API.APIDelApps;
import itdel.com.papkwebservice.API.ResponseFasilitas;
import itdel.com.papkwebservice.controller.ControllerFasilitas;
import itdel.com.papkwebservice.controller.ControllerKegiatan;
import itdel.com.papkwebservice.model.Fasilitas;
import itdel.com.papkwebservice.model.Kegiatan;
import itdel.com.papkwebservice.R;
import itdel.com.papkwebservice.API.RESTClient;
import itdel.com.papkwebservice.API.ResponseKegiatan;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button kegiatanButton;
    Button fasilitasButton;
    Button deskripsiButton;

    Context myContext;
    ProgressDialog progress;
    APIDelApps apiDelApps;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kegiatanButton = (Button)findViewById(R.id.kegiatanButton);
        kegiatanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContext = getApplicationContext();
                progress = ProgressDialog.show(MainActivity.this,"Inisialisasi Data", "Sedang Mengunduh Data untuk Aplikasi", true);
                Callback<ResponseKegiatan> listKegiatan = new Callback<ResponseKegiatan>()
                {

                    @Override
                    public void onResponse(Call<ResponseKegiatan> call, Response<ResponseKegiatan> response) {
                        if(response.isSuccessful())
                        {
                            List<Kegiatan> hasilListKegiatan = response.body().getListKegiatan();
                            int jumlahData = response.body().getListKegiatan().size();
                            if(jumlahData > 0)
                            {
                                ControllerKegiatan controllerKegiatan = new ControllerKegiatan(myContext);
                                controllerKegiatan.open();
                                controllerKegiatan.deleteData();
                                for(int x = 0;x<jumlahData;x++)
                                {
                                    Kegiatan kegiatan = hasilListKegiatan.get(x);
                                    controllerKegiatan.insertData(kegiatan.getId(),kegiatan.getNamaKegiatan(),kegiatan.getDeskripsiKegiatan());
                                }
                                controllerKegiatan.close();
                                Intent sendIntent =  new Intent(myContext, KegiatanActivity.class);
                                startActivity(sendIntent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "DATA Sedang Tidak Tersedia", Toast.LENGTH_LONG).show();
                            }
                            progress.dismiss();
                        }
                        else
                        {
                            Log.e("onResponse failure", "Code : "+" Message : "+response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseKegiatan> call, Throwable t) {
                        progress.dismiss();
                        Toast.makeText(getApplicationContext(), "Akses Ke Server Gagal"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                };
                apiDelApps = RESTClient.get();
                Call<ResponseKegiatan> callKegiatan = apiDelApps.getKegiatan();
                callKegiatan.enqueue(listKegiatan);
            }
        });
        fasilitasButton = (Button)findViewById(R.id.fasilitasButton);
        fasilitasButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myContext = getApplicationContext();
                progress = ProgressDialog.show(MainActivity.this,"Inisialisasi Data", "Sedang Mengunduh Data untuk Aplikasi", true);
                Callback<ResponseFasilitas> listFasilitas = new Callback<ResponseFasilitas>()
                {

                    @Override
                    public void onResponse(Call<ResponseFasilitas> call, Response<ResponseFasilitas> response) {
                        if(response.isSuccessful())
                        {
                            List<Fasilitas> hasilListFasilitas = response.body().getListFasilitas();
                            int jumlahData = response.body().getListFasilitas().size();
                            if(jumlahData > 0)
                            {
                                ControllerFasilitas controllerFasilitas = new ControllerFasilitas(myContext);
                                controllerFasilitas.open();
                                controllerFasilitas.deleteData();
                                for(int x = 0;x<jumlahData;x++)
                                {
                                    Fasilitas fasilitas = hasilListFasilitas.get(x);
                                    System.out.println(fasilitas.getDeskripsiFasilitas());
                                    controllerFasilitas.insertData(fasilitas.getId(), fasilitas.getNamaFasilitas(), fasilitas.getDeskripsiFasilitas());
                                }
                                controllerFasilitas.close();
                                Intent sendIntent =  new Intent(myContext, FasilitasActivity.class);
                                startActivity(sendIntent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "DATA Sedang Tidak Tersedia", Toast.LENGTH_LONG).show();
                            }
                            progress.dismiss();
                        }
                        else
                        {
                            Log.e("onResponse failure", "Code : "+" Message : "+response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseFasilitas> call, Throwable t) {
                        progress.dismiss();
                        Toast.makeText(getApplicationContext(), "Akses Ke Server Gagal"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                };
                apiDelApps = RESTClient.get();
                Call<ResponseFasilitas> callFasilitas = apiDelApps.getFasilitas();
                callFasilitas.enqueue(listFasilitas);
            }
        });

        deskripsiButton = (Button) findViewById(R.id.deksripsiButton);
        deskripsiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent sendIntent = new Intent(MainActivity.this, DeksripsiActivity.class);
                startActivity(sendIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will // automatically handle clicks on the Home/Up button, so long // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
