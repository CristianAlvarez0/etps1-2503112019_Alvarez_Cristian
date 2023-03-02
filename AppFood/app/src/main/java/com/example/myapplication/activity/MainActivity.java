package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout btnInicial;
    EditText etUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInicial=findViewById(R.id.btnInicio);
        etUser = findViewById(R.id.editTextTextPersonName);


        btnInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Principal.class);
                i.putExtra("usuario",etUser.getText().toString());
                startActivity(i);
            }
        });

    }
}