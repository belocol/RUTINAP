package com.example.rutinap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class App extends AppCompatActivity {

    Button btnrutinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);



        btnrutinas = (Button) findViewById(R.id.btnRutinas);


        btnrutinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(),CrudRutinas.class);
                startActivity(i);
            }
        });

    }




}