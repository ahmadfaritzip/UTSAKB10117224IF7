package com.example.utsakb10117224if7.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbOpenHelper extends SQLiteOpenHelper {
    public DbOpenHelper(Context context) {
        super(context, AppDbHelper.DB_NAME, null, AppDbHelper.DB_VERSION);
//        context.deleteDatabase(AppDbHelper.DB_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        String sqlQuery = "CREATE TABLE "+ AppDbHelper.TABLE +" (" +
                AppDbHelper.Columns.C_NIM+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                AppDbHelper.Columns.C_NAMA +" TEXT, "+
                AppDbHelper.Columns.C_KELAS+" TEXT, " +
                AppDbHelper.Columns.C_TELEPON+" TEXT, " +
                AppDbHelper.Columns.C_EMAIL+" TEXT, " +
                AppDbHelper.Columns.C_SOSMED + " TEXT);";
        Log.d("DataHelper","Query to form table: "+sqlQuery);
        sqlDB.execSQL(sqlQuery);
//        sqlDB.execSQL(AppDbHelper.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
        sqlDB.execSQL("DROP TABLE IF EXISTS "+ AppDbHelper.TABLE);
        Log.d("DataHelper","table: "+sqlDB);
        onCreate(sqlDB);
    }

    public boolean insertData(String nim, String nama, String kelas, String telp, String email, String sosmed){
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppDbHelper.Columns.C_NIM, nim);
        contentValues.put(AppDbHelper.Columns.C_NAMA, nama);
        contentValues.put(AppDbHelper.Columns.C_KELAS, kelas);
        contentValues.put(AppDbHelper.Columns.C_TELEPON, telp);
        contentValues.put(AppDbHelper.Columns.C_EMAIL, email);
        contentValues.put(AppDbHelper.Columns.C_SOSMED, sosmed);

        long result = db.insert(AppDbHelper.TABLE, null, contentValues);

        if (result == -1){ return false; }else{ return true; }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM "+ DataContact.TABLE ;
//        Cursor data = db.rawQuery(query + "ORDER BY " + DataContact.Columns._ID + " DESC", null);
        Cursor data = db.query(AppDbHelper.TABLE,
                null,
                null,
                null,
                null,
                null,
                AppDbHelper.Columns.C_NIM);
        return data;
    }

    public Cursor getData(String nim){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("Select * from "+ AppDbHelper.TABLE +" where "+
                AppDbHelper.Columns.C_NIM +"=" + nim + "", null);
        return data;
    }

    public void deleteData(String nim){
        String query = "DELETE FROM " + AppDbHelper.TABLE + " WHERE nim = '"+nim+"'";
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        sqlDB.execSQL(query);
    }

    public void updateData(String nim, String nama, String kelas, String telp, String email, String sosmed){
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AppDbHelper.Columns.C_NAMA, nama);
        cv.put(AppDbHelper.Columns.C_KELAS, kelas);
        cv.put(AppDbHelper.Columns.C_TELEPON, telp);
        cv.put(AppDbHelper.Columns.C_EMAIL, email);
        cv.put(AppDbHelper.Columns.C_SOSMED, sosmed);
        db.update(AppDbHelper.TABLE, cv, AppDbHelper.Columns.C_NIM+ "=" +nim, null);
    }
}
