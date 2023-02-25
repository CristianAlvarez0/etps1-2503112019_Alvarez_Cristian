package sv.edu.utec.educhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btIngreso;
    Button btRegistro;
    EditText etUsu;
    EditText etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btIngreso = findViewById(R.id.btnIngresar);
        btRegistro = findViewById(R.id.btnRegistrate);
        etUsu = findViewById(R.id.edtUsuario);
        etPass = findViewById(R.id.edtPassword);

        btIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),PantallaPrincipal.class);
                startActivity(intento);
            }
        });
    }
    public void PantallaRegistro(View v){
        Intent intento=new Intent(this,PantallaRegistro.class);
        startActivity(intento);

    }
}