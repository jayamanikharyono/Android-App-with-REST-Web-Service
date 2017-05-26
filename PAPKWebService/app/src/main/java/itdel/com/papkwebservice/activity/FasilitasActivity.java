package itdel.com.papkwebservice.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
import itdel.com.papkwebservice.controller.ControllerFasilitas;
import itdel.com.papkwebservice.model.Fasilitas;

public class FasilitasActivity extends Activity {
    ListView grdData;
    Button refreshButton;
    Button homeButton;

    private static final class Holder
    {
        public ImageView imageFasilitas;
        public TextView namaFasilitas;
        public TextView deskripsiFasilitas;
    }

    public FasilitasActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasilitas);
        grdData = (ListView) findViewById(R.id.grdFasilitas);
        ControllerFasilitas myData = new ControllerFasilitas(this);
        refreshButton = (Button) findViewById(R.id.buttonRefreshfasilitas);
        homeButton = (Button) findViewById(R.id.buttonHomeFasilitas);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refreshIntent =  new Intent(FasilitasActivity.this, FasilitasActivity.class);
                startActivity(refreshIntent);
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent =  new Intent(FasilitasActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
        myData.open();
        myData.getFasilitas();
        HasilFasilitasAdapter adapter =  new HasilFasilitasAdapter(this, android.R.layout.simple_list_item_1,myData.getFasilitas());
        grdData.setAdapter(adapter);
        myData.close();
    }
    private class HasilFasilitasAdapter extends ArrayAdapter<Fasilitas>
    {
        private LayoutInflater mInflater;
        public HasilFasilitasAdapter(Context context, int textViewResourceId, List<Fasilitas> objects)
        {
            super(context,textViewResourceId,objects);
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View view = convertView;
            Holder holder;
            if(view == null)
            {
                view = mInflater.inflate(R.layout.list_fasilitas,parent,false);
                holder = new Holder();
                holder.imageFasilitas = (ImageView) view.findViewById(R.id.iconFasilitas);
                holder.namaFasilitas = (TextView) view.findViewById(R.id.firstLineFasilitas);
                holder.deskripsiFasilitas = (TextView) view.findViewById(R.id.secondLineFasilitas);
                view.setTag(holder);
            }
            else
            {
                holder = (Holder) view.getTag();
            }
            Fasilitas stream = getItem(position);
            holder.imageFasilitas.setImageResource(getResources().getIdentifier( stream.getNamaFasilitas().toLowerCase().replaceAll("\\s+",""),"drawable","itdel.com.papkwebservice"));
            System.out.println(stream.getNamaFasilitas());
            System.out.println(stream.getDeskripsiFasilitas());
            holder.namaFasilitas.setText(stream.getNamaFasilitas());
            holder.deskripsiFasilitas.setText(stream.getDeskripsiFasilitas());
            return view;
        }
    }
}
