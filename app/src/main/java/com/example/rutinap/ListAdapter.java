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

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> LiData;
    private LayoutInflater LiInflater;
    private Context context;


    public ListAdapter(List<ListElement> itemList, Context context){
        this.LiInflater = LayoutInflater.from(context);
        this.context = context;
        this.LiData = itemList;

    }

    @Override

    public int getItemCount() {return LiData.size();}



    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LiInflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(view);
    }


    @Override

    public void onBindViewHolder (final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(LiData.get(position));
    }


    public void setItems(List<ListElement> items) {LiData = items;}


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImageView;
        TextView Nrutina;


        ViewHolder(View itemView){
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            Nrutina = itemView.findViewById(R.id.Nrutina);

        }



        void bindData(final ListElement item){
            Nrutina.setText(item.getNrtuina());
        }

    }

}
