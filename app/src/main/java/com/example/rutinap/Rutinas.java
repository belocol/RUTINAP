package com.example.rutinap;

import java.io.Serializable;

public class Rutinas  implements Serializable {

    private String Nrutina;

    public Rutinas (String Nrutina){
        this.Nrutina = Nrutina;

    }

    public String getNrutina() {
        return Nrutina;
    }

    public void setNrutina(String nrutina) {
        this.Nrutina = nrutina;
    }

    public Rutinas(){


    }



}
