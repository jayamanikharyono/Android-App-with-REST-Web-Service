package itdel.com.papkwebservice.DBHelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import itdel.com.papkwebservice.controller.ControllerFasilitas;
import itdel.com.papkwebservice.controller.ControllerKegiatan;

/**
 * Created by Jayuk on 19/05/2017.
 */

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "data.db";
    public DBHelper(Context context)
    {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ControllerKegiatan.CREATE_LISTKEGIATAN);
        db.execSQL(ControllerFasilitas.CREATE_LISTFASILITAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ControllerKegiatan.TABLE_NAMEKEGIATAN);
        db.execSQL("DROP TABLE IF EXISTS "+ControllerFasilitas.TABLE_NAMEFASILITAS);
        onCreate(db);
    }
}