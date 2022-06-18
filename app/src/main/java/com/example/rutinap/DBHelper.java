package com.example.rutinap;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table pecho(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table espalda(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table pierna(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table gluteo(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table abdomen(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table hombro(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table tricep(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table bicep(nombreejercicio TEXT primary key)");
        MyDB.execSQL("create Table antebrazo(nombreejercicio TEXT primary key)");

        MyDB.execSQL("INSERT INTO pecho (nombreejercicio) values ('Press De Banca Plano')");
        MyDB.execSQL("INSERT INTO pecho (nombreejercicio) values ('Press Banca Inclinado')");
        MyDB.execSQL("INSERT INTO pecho (nombreejercicio) values ('Press Banca Declinado')");
        MyDB.execSQL("INSERT INTO pecho (nombreejercicio) values ('Apertura Con Mancuernas Banco Plano')");



        MyDB.execSQL("INSERT INTO espalda (nombreejercicio) values ('Polea Al Pecho')");
        MyDB.execSQL("INSERT INTO espalda (nombreejercicio) values ('Polea Al Pecho Con Agarre Estrecho')");
        MyDB.execSQL("INSERT INTO espalda (nombreejercicio) values ('Remo En Maquina')");
        MyDB.execSQL("INSERT INTO espalda (nombreejercicio) values ('Remo Horizontal A Una Mano Con Mancuerna')");



        MyDB.execSQL("INSERT INTO pierna (nombreejercicio) values ('Prensa')");
        MyDB.execSQL("INSERT INTO pierna (nombreejercicio) values ('Sentadilla Frontal')");
        MyDB.execSQL("INSERT INTO pierna (nombreejercicio) values ('Extensiones')");
        MyDB.execSQL("INSERT INTO pierna (nombreejercicio) values ('Curl De Piernas Acostado')");








    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists pecho");
        MyDB.execSQL("drop Table if exists espalda");
        MyDB.execSQL("drop Table if exists pierna");
        MyDB.execSQL("drop Table if exists gluteo");
        MyDB.execSQL("drop Table if exists abdomen");
        MyDB.execSQL("drop Table if exists hombro");
        MyDB.execSQL("drop Table if exists tricep");
        MyDB.execSQL("drop Table if exists bicep");
        MyDB.execSQL("drop Table if exists antebrazo");
    }





    public Boolean insertData(String user,String pass){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", user);

        contentValues.put("password", pass);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}