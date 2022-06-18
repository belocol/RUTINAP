package com.example.rutinap;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolderDatos>
implements View.OnClickListener{


    ArrayList<Rutinas> listDatos;
    private View.OnClickListener listener;

    public ListAdapter(ArrayList<Rutinas> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element,null,false);

        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.Nrutina.setText(listDatos.get(position).getNrutina());

        //holder.asingarDatos(listDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {

        if(listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView Nrutina;




        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            Nrutina=(TextView ) itemView.findViewById(R.id.Nrutina);

        }

        public void asingarDatos(String Nrutinas ) {

            Nrutina.setText(Nrutinas);

        }
    }
}
