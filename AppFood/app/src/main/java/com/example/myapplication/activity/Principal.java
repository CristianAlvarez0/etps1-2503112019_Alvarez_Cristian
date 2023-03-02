package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class Principal extends AppCompatActivity {
TextView etMEN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        etMEN = findViewById(R.id.tvUusario);
        Bundle bundle=getIntent().getExtras();
        String info = "Hola, "+bundle.getString("usuario");
        etMEN.setText(info);
    }
}