package itdel.com.papkwebservice.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import itdel.com.papkwebservice.DBHelp.DBHelper;
import itdel.com.papkwebservice.model.Kegiatan;

/**
 * Created by Jayuk on 19/05/2017.
 */

public class ControllerKegiatan
{
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    public static final String TABLE_NAMEKEGIATAN = "listKegiatan";
    public static final String ID = "id";
    public static final String NAMA_KEGIATAN = "namaKegiatan";
    public static final String DESK_KEGIATAN = "deksKegiatan";
    public static final String CREATE_LISTKEGIATAN = "CREATE TABLE "+TABLE_NAMEKEGIATAN+
            " ("+ID+" integer primary key, "+NAMA_KEGIATAN+" TEXT, "+DESK_KEGIATAN+" TEXT)";
    private String[] TABLE_COLUMNS = {ID,NAMA_KEGIATAN, DESK_KEGIATAN};
    public ControllerKegiatan(Context context)
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
        database.delete(TABLE_NAMEKEGIATAN,null,null);
    }
    public void insertData(int id, String namaKegiatan, String deskripsiKegiatan)
    {
        ContentValues contentValues =  new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAMA_KEGIATAN,namaKegiatan);
        contentValues.put(DESK_KEGIATAN, deskripsiKegiatan);
        database.insert(TABLE_NAMEKEGIATAN,null,contentValues);
    }

    public ArrayList<Kegiatan> getKegiatan()
    {
        ArrayList<Kegiatan> allKegiatan =  new ArrayList<>();
        Cursor cursor = null;
        cursor = database.query(TABLE_NAMEKEGIATAN,TABLE_COLUMNS,null,null,null,null, ID+" ASC");
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            allKegiatan.add(parseData(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return allKegiatan;
    }

    public Kegiatan parseData(Cursor cursor)
    {
        Kegiatan kegiatan =  new Kegiatan();
        kegiatan.setId(cursor.getInt(0));
        kegiatan.setNamaKegiatan(cursor.getString(1));
        kegiatan.setDeskripsiKegiatan(cursor.getString(2));
        return kegiatan;
    }
}
