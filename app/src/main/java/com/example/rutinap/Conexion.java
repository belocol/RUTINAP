package com.example.rutinap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {

    static String DBNAME="Rutinap";// nombre de la base de datos
    static String registro="registro_user";
    static String ingreso="ingreso_user";
    // AQUI EN DONDE SE CREAN LAS TABLAS DE LA BASE DE DATOS
    static int DBVERSION=1;

    String sqlusuarios ="CREATE TABLE "+registro+"(email TEXT PRIMARY KEY ,password TEXT );";
   // String sqlusuarios ="CREATE TABLE "+registro+"(email TEXT PRIMARY KEY, nombre TEXT, password TEXT ,password2 TEXT);";
    String sqlingreso ="CREATE TABLE "+ingreso+"(email TEXT PRIMARY KEY, password TEXT);";

    public Conexion(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL(sqlusuarios);
        //db.execSQL(sqlingreso);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        MyDB.execSQL("Drop table If exists "+registro);
        onCreate(MyDB);
    }

    public Boolean insertData( String email, String password ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email", email);
        //contentValues.put("nombre", nombre);
        contentValues.put("password", password);
        //contentValues.put("password2", password2);


        long result = MyDB.insert("registro", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from registro where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    public Boolean checkusernamepassword(String email, String password){
        SQLiteDatabase  db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from registro where Email = ? and Password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
