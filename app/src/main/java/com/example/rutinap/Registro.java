package com.example.rutinap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {


    TextView Nombre, Email , Password, Password2;
    Button Registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Conexion conn = new Conexion(getApplicationContext());

        Nombre=findViewById(R.id.tvnombre);
        Email=findViewById(R.id.tvemail);
        Password=findViewById(R.id.tvpassword1);
        Password2=findViewById(R.id.tvpassword2);
        Registrar=findViewById(R.id.btnRegistrarse);



        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsuarios dbUsuarios = new DbUsuarios(Registro.this);

                long id= dbUsuarios.insertarUsuario(Nombre.getText().toString(),Email.getText().
                        toString(),Password.getText().toString());


                if(id>0){
                    limpiar();
                    Toast.makeText(Registro.this ,"Registro guardado",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Registro.this ,"Error al guardar registro",Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    private void limpiar(){
        Nombre.setText("");
        Email.setText("");
        Password.setText("");
        Password2.setText("");

    }
}