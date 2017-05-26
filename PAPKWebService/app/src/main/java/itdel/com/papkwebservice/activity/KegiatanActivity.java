package itdel.com.papkwebservice.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import itdel.com.papkwebservice.R;
import itdel.com.papkwebservice.controller.ControllerKegiatan;
import itdel.com.papkwebservice.model.Kegiatan;

public class KegiatanActivity extends Activity {

    ListView grdListKegiatan;
    Button refreshButton;
    Button homeButton;

    private static final class Holder
    {
        public ImageView imageKegiatan;
        public TextView namaKegiatan;
        public TextView deskripsiKegiatan;
    }
    public KegiatanActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatan);
        grdListKegiatan =(ListView) findViewById(R.id.grdKegiatan);
        ControllerKegiatan myData =  new ControllerKegiatan(this);
        refreshButton = (Button) findViewById(R.id.buttonRefreshKegiatan);
        homeButton = (Button) findViewById(R.id.buttonHomeKegiatan);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refreshIntent =  new Intent(KegiatanActivity.this, KegiatanActivity.class);
                startActivity(refreshIntent);
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent =  new Intent(KegiatanActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
        myData.open();
        myData.getKegiatan();
        System.out.println(myData.getKegiatan().get(0).getId());
        System.out.println(myData.getKegiatan().get(0).getNamaKegiatan());
        System.out.println(myData.getKegiatan().get(0).getDeskripsiKegiatan());
        KegiatanAdapter adapter =  new KegiatanAdapter(this, android.R.layout.simple_list_item_1, myData.getKegiatan());
        grdListKegiatan.setAdapter(adapter);
        myData.close();
    }
    private class KegiatanAdapter extends ArrayAdapter<Kegiatan>
    {
        private LayoutInflater mInflater;
        public KegiatanAdapter(Context context, int textViewResourceId, List<Kegiatan> objects) {
            super(context,textViewResourceId,objects);
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            Holder holder;
            if (view == null) {
                view = mInflater.inflate(R.layout.list_kegiatan, parent, false);
                holder = new Holder();
                holder.imageKegiatan = (ImageView) view.findViewById(R.id.iconKegiatan);
                holder.namaKegiatan = (TextView) view.findViewById(R.id.firstLineKegiatan);
                holder.deskripsiKegiatan = (TextView) view.findViewById(R.id.secondLineKegiatan);
                view.setTag(holder);
            } else {
                holder = (Holder) view.getTag();
            }
            Kegiatan stream = getItem(position);
            holder.imageKegiatan.setImageResource(getResources().getIdentifier( stream.getNamaKegiatan().toLowerCase().replaceAll("\\s+",""),"drawable","itdel.com.papkwebservice"));
            holder.namaKegiatan.setText(stream.getNamaKegiatan());
            holder.deskripsiKegiatan.setText(stream.getDeskripsiKegiatan());
            return view;
        }
    }
}
