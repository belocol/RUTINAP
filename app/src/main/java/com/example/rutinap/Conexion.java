package com.example.rutinap;

import android.content.Context;
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

    String sqlusuarios ="CREATE TABLE "+registro+"(email TEXT PRIMARY KEY, nombre TEXT, password TEXT);";
    String sqlingreso ="CREATE TABLE "+ingreso+"(email TEXT PRIMARY KEY, password TEXT);";

    public Conexion(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db ){

        db.execSQL(sqlusuarios);
        db.execSQL(sqlingreso);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table If exists "+registro);
        onCreate(db);
    }

    //aun faltan todos los metodos de Crear , Leer , Eliminar y actualizar pero lo importante es crear la conexion por ahora xd
}
