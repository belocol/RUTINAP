package com.example.rutinap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class NuevaRutina extends AppCompatActivity {

    ArrayList<Rutinas> listDatos;
    RecyclerView recyclerView;
    Button añadiRutina;

    DBHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_rutina);

        conn = new DBHelper(this);

        listDatos = new ArrayList<>();








        recyclerView = (RecyclerView) findViewById(R.id.LiNuevasRutinas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        consultarListaRutinas();

        ListAdapter adapter  = new ListAdapter(listDatos);


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db=conn.getReadableDatabase();

                ContentValues values =new ContentValues();
                values.put("nombreejercicio ",listDatos.get(recyclerView.getChildAdapterPosition(view)).getNrutina());

                Toast.makeText(getApplicationContext(),
                        "Sellecion: " +listDatos.get
                                (recyclerView.getChildAdapterPosition(view)).getNrutina(),Toast.LENGTH_SHORT).show();


                db.insert("tricep",null,values);
            }
        });

        recyclerView.setAdapter(adapter);






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