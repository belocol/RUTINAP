/*package com.example.rutinap;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbUsuarios extends  Conexion{

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context=context;

    }

    public long insertarUsuario(String Email, String Nombre, String Password , String Password2){


        long id = 0;
        try{

            Conexion conexion = new Conexion(context);
            SQLiteDatabase db= conexion.getWritableDatabase();

            ContentValues values=new ContentValues();
            values.put("Email",Email);
            values.put("Nombre",Nombre);
            values.put("Password",Password);
            values.put("Password",Password2);
            id= db.insert(registro,null,values);
        }

       catch (Exception ex){
            ex.toString();
       }
        return  id;


    }
}
*/

//  Este archivo ya es obsoleto el codigo no sirve.

