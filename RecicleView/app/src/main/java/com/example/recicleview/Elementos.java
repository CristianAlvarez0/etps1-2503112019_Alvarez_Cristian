package com.example.recicleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Elementos extends RecyclerView.ViewHolder{
    ImageView imgPelic;
    static TextView tvnomPel,tvGenPeli;
    public Elementos(@NonNull View itemView) {
        super(itemView);
        imgPelic=itemView.findViewById(R.id.imgPeli);
        tvnomPel=itemView.findViewById(R.id.tvTitulo);
        tvGenPeli=itemView.findViewById(R.id.tvGenero);
    }

}
