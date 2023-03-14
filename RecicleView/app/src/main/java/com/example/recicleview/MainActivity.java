package com.example.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    Adapatador adaptador;
    ListView ListaDias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = findViewById(R.id.peliculas);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new Adapatador(this, getListado());
        mrecyclerView.setAdapter(adaptador);




        mrecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View View, int position, long id) {
                Toast.makeText(parent.getContext(), "Seleccionar", Toast.LENGTH_LONG).show();
            }
        });
    }




    private ArrayList<Modelo> getListado(){
        ArrayList<Modelo> modelos = new ArrayList<>();
        Modelo modelolista = new Modelo();
        modelolista.setNoombPeli("Ex-Maquina");
        modelolista.setGeneroPeli("Juan Perez");
        modelolista.setGeneroPeli("Ciencia Ficcion");
        modelolista.setImgPeli(R.drawable.ex_maquina);
        modelolista.setAnioPeli("1999");
        modelolista.setDuraPeli("108 min");
        modelos.add(modelolista);


        return modelos;
    }
}