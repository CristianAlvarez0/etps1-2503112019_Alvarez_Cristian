package com.example.recicleview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Listas extends AppCompatActivity {
ListView listaDias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        listaDias=findViewById(R.id.lvDias);

        ArrayAdapter<CharSequence> adaptador=ArrayAdapter.createFromResource(this,R.array.arregloDias, android.R.layout.simple_list_item_1);
        listaDias.setAdapter(adaptador);

        listaDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}