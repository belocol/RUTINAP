package com.example.rutinap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {


    TextView Nombre, Email , Password, Password2;
    Button Registrar;

    Conexion DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB= new Conexion(this);

        Nombre=findViewById(R.id.tvnombre);
        Email=findViewById(R.id.tvemail);
        Password=findViewById(R.id.tvpassword1);
        Password2=findViewById(R.id.tvpassword2);
        Registrar=findViewById(R.id.btnRegistrarse);



        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nombre =Nombre.getText().toString();
                String email =Email.getText().toString();
                String password =Password.getText().toString();
                String password2 =Password2.getText().toString();

                if(nombre.equals("")||email.equals("")||password.equals("")||password2.equals(""))
                    Toast.makeText(Registro.this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(password2)){
                        Boolean checkuser = DB.checkusername(email);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(email,password);
                            if(insert==true){
                                Toast.makeText(Registro.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                                limpiar();
                                Intent intent = new Intent(getApplicationContext(),login.class);

                                startActivity(intent);
                            }else{
                                Toast.makeText(Registro.this, "Hubo un error", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Registro.this, "Este usuario ya existe, Inicie Sesion", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
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

    /*private void limpiar(){
        Nombre.setText("");
        Email.setText("");
        Password.setText("");
        Password2.setText("");
    */