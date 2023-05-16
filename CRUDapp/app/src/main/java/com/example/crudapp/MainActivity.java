package com.example.crudapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.example.crudapp.datos.baseHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drwLayout;
    Toolbar tlBarra;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tlBarra = findViewById(R.id.toolbar);
        drwLayout=findViewById(R.id.drawerlayout);
        navView=findViewById(R.id.navigator);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drwLayout,tlBarra,R.string.open,R.string.close);
        drwLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));


        baseHelper basehelper = new baseHelper(this);
        SQLiteDatabase db=basehelper.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this,"Base de datos creada",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Error en crear la Base de datos ",Toast.LENGTH_SHORT).show();
        }


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.mensajes://YA
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Mensaje",Toast.LENGTH_SHORT).show();
                        fragmentos(new MensajesFragment());
                        break;

                    case R.id.comentarios://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Comentarios",Toast.LENGTH_SHORT).show();
                        fragmentos(new ComentariosFragment());
                        break;

                    case R.id.enviar://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Enviar",Toast.LENGTH_SHORT).show();
                        fragmentos(new EnviarFragment());
                        break;

                    case R.id.compartir://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Compartir",Toast.LENGTH_SHORT).show();
                        fragmentos(new CompartirFragment());
                        break;

                    case R.id.explorar://YA
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Encontrar",Toast.LENGTH_SHORT).show();
                        fragmentos(new ExplorarFragment());
                        break;


                }

                return true;
            }
        });

    }
    private void fragmentos(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmlayoutContenedor,fragment);
        fragmentTransaction.commit();



    }


}