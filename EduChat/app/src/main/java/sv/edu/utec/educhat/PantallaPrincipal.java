package sv.edu.utec.educhat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.educhat.opciones.Configuracion;
import sv.edu.utec.educhat.opciones.NuevoGrupo;
import sv.edu.utec.educhat.opciones.Perf;




public class PantallaPrincipal extends AppCompatActivity {



//chat

    String [] ftperfil={"Grupo 1","Grupo 2"};
    ListView lvstChat;
    Integer []ImgChat= {
            R.drawable.ftperfilchat1,
            R.drawable.ftperfilchat2,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);


        //CHAT
        AdaptadorChat adaptador = new AdaptadorChat(this, ftperfil,ImgChat);
        lvstChat = findViewById(R.id.lstChats);
        lvstChat.setAdapter(adaptador);

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pantallamenu,menu);
        return true ;

    }


    public boolean onOptionsItemSelected(MenuItem items){

        Intent intent = new Intent(this, Perf.class);
        Intent intent1 = new Intent(this, Configuracion.class);
        Intent intent2 = new Intent(this, NuevoGrupo.class);
        Intent intent3 = new Intent(this, MainActivity.class);

        switch (items.getItemId()){

            case R.id.nav_nuevogrup:
                startActivity(intent2);
                Toast.makeText(this,"Selecciono nuevo grupo ",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_profile:
                Toast.makeText(this,"Selecciono perfil",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            case R.id.nav_settings:
                startActivity(intent1);
                Toast.makeText(this,"Selecciono configuración",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_logout:
                startActivity(intent3);
                Toast.makeText(this,"Selecciono salir",Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(items);
    }


}