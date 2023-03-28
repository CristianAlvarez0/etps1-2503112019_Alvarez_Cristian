package com.example.menuopciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        switch (items.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this,"Selecciono la opcion 1" +1, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion2:
                Toast.makeText(this,"Selecciono la opcion 2" +1, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion3:
                Toast.makeText(this,"Selecciono la opcion 3" +1, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion4:
                Toast.makeText(this,"Selecciono la opcion 4" +1, Toast.LENGTH_SHORT).show();
                return true;


        }
        return super.onOptionsItemSelected(items);
    }
}