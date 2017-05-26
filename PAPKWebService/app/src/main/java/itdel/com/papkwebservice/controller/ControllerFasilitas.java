package itdel.com.papkwebservice.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import itdel.com.papkwebservice.DBHelp.DBHelper;
import itdel.com.papkwebservice.model.Fasilitas;

/**
 * Created by Jayuk on 22/05/2017.
 */

public class ControllerFasilitas
{
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    public static final String TABLE_NAMEFASILITAS = "listFasilitas";
    public static final String ID = "id";
    public static final String NAMA_FASILITAS = "namaFasilitas";
    public static final String DESK_FASILITAS = "deksFasilitas";
    public static final String CREATE_LISTFASILITAS = "CREATE TABLE "+TABLE_NAMEFASILITAS+
            " ("+ID+" integer primary key, "+NAMA_FASILITAS+" TEXT, "+DESK_FASILITAS+" TEXT)";
    private String[] TABLE_COLUMNS = {ID,NAMA_FASILITAS, DESK_FASILITAS};
    public ControllerFasilitas(Context context)
    {
        dbHelper =  new DBHelper(context);
    }
    public void open() throws SQLException
    {
        database = dbHelper.getWritableDatabase();
    }
    public void close()
    {
        dbHelper.close();
    }
    public void deleteData()
    {
        database.delete(TABLE_NAMEFASILITAS,null,null);
    }
    public void insertData(int id, String namaFasilitas, String deskripsiFasilitas)
    {
        ContentValues contentValues =  new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAMA_FASILITAS,namaFasilitas);
        contentValues.put(DESK_FASILITAS, deskripsiFasilitas);
        database.insert(TABLE_NAMEFASILITAS,null,contentValues);
    }

    public ArrayList<Fasilitas> getFasilitas()
    {
        ArrayList<Fasilitas> allFasilitas =  new ArrayList<>();
        Cursor cursor = null;
        cursor = database.query(TABLE_NAMEFASILITAS,TABLE_COLUMNS,null,null,null,null, ID+" ASC");
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            allFasilitas.add(parseData(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return allFasilitas;
    }

    public Fasilitas parseData(Cursor cursor)
    {
        Fasilitas fasilitas =  new Fasilitas();
        fasilitas.setId(cursor.getInt(0));
        fasilitas.setNamaFasilitas(cursor.getString(1));
        fasilitas.setDeskripsiFasilitas(cursor.getString(2));
        return fasilitas;
    }
}
