package itdel.com.papkwebservice.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import itdel.com.papkwebservice.R;

public class DeksripsiActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deksripsi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deksripsi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private ArrayList<String> listDeskripsi =  new ArrayList<>();

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            listDeskripsi.add("Yayasan Del mulai aktif di kegiatan sosial kemasyarakatan jauh sebelum didirikannya PT Toba Sejahtera, perusahaan yang kemudian menjadi Yayasan Del sebagai tonggak tanggung jawab sosial perusahaan.");
            listDeskripsi.add("Tujuan awal Yayasan Del didirikan adalah untuk memberikan akses pendidikan berkualitas di daerah terpencil bagi siswa/i berprestasi dengan latar belakang ekonomi yang kurang menguntungkan, yaitu dengan mendirikan Politeknik Informatika Del dan SMA Unggul Del di Laguboti, Sumatera Utara serta Sekolah NOAH di Kalisari, Jakarta Timur.");
            listDeskripsi.add("Tidak hanya berkiprah di bidang pendidikan, Yayasan Del juga aktif bekerjasama dengan pemerintah daerah dan lembaga sosial yang ada di Indonesia untuk meningkatkan pelayanan serta memperluas cakrawala bidang pelayanan strategis lainnya.");
            listDeskripsi.add("Politeknik Informatika Del didirikan pada tahun 2001 dan bertujuan untuk menyediakan pendidikan tinggi berkualitas internasional, bagi siswa/i berpotensi, terutama dengan latar belakang ekonomi yang kurang menguntungkan, khususnya yang berasal dari Sumatera Utara.");
            listDeskripsi.add("Dengan lokasi di daerah tepian Danau Toba, berjarak sekitar 400 KM dari kota Medan, area IT Del diharapkan dapat memberikan suasana tenang dan kondusif dalam belajar, karena jauh dari kebisingan dan hiruk pikuk suasana perkotaan/perindustrian.");

            View rootView = inflater.inflate(R.layout.fragment_deksripsi, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            TextView deskripsitext = (TextView) rootView.findViewById(R.id.deksripsiText);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageFragment);
            deskripsitext.setText(listDeskripsi.get(getArguments().getInt(ARG_SECTION_NUMBER)-1));
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            imageView.setImageResource(getResources().getIdentifier("itdel" + getArguments().getInt(ARG_SECTION_NUMBER),"drawable","itdel.com.papkwebservice"));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECTION 5";
            }
            return null;
        }
    }
}
