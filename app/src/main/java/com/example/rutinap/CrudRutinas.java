package com.example.rutinap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CrudRutinas extends AppCompatActivity {

ArrayList<Rutinas> listDatos;
RecyclerView recyclerView;

DBHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_rutinas);



        conn = new DBHelper(this);

        listDatos = new ArrayList<>();


        recyclerView = (RecyclerView) findViewById(R.id.LiRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        consultarListaRutinas();



        ListAdapter adapter  = new ListAdapter(listDatos);
        recyclerView.setAdapter(adapter);
        /*listDatos= new ArrayList<String>();


        for(int i=0;i<=50;i++){
            listDatos.add("Dato # "+i+"");

        }*/


      /*  ListAdapter adapter = new ListAdapter(listDatos);
        recyclerView.setAdapter(adapter);
*/
    }

    private void consultarListaRutinas() {
        SQLiteDatabase db=conn.getReadableDatabase();

       Rutinas rutinas = null;


        Cursor cursor = db.rawQuery("SELECT * FROM pecho ",null);


        while (cursor.moveToNext()){

            rutinas =new Rutinas();
            rutinas.setNrutina(cursor.getString(0));

            listDatos.add(rutinas);
        }

    }
}