package com.example.rutinap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CrudRutinas extends AppCompatActivity {

ArrayList<Rutinas> listDatos;
RecyclerView recyclerView;
Button btnNuevaRutina;

DBHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_rutinas);



        conn = new DBHelper(this);

        listDatos = new ArrayList<>();


        btnNuevaRutina= (Button) findViewById(R.id.btnNewRutina);





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

        btnNuevaRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),NuevaRutina.class);
                startActivity(i);
            }
        });

    }


}