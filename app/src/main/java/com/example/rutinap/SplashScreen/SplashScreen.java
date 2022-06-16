package com.example.rutinap.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.rutinap.Inicio;
import com.example.rutinap.R;
import com.example.rutinap.Registro;

public class SplashScreen extends AppCompatActivity {

    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        timer= new Thread(){
            public  void run(){
                try{
                    synchronized (this){
                        wait(2850);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent =new Intent(SplashScreen.this, Inicio.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}