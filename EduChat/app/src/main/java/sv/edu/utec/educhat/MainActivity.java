package sv.edu.utec.educhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btIngreso;
    EditText etUsu;
    EditText etPass;
    TextView tvCrearCue;
    TextView tvOlvideContra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btIngreso = findViewById(R.id.btnIngresar);
        etUsu = findViewById(R.id.edtUsuario);
        etPass = findViewById(R.id.edtPassword);
        tvCrearCue=findViewById(R.id.tvCrearCuenta);
        tvOlvideContra=findViewById(R.id.tvOlvideContraseña);


        tvCrearCue.setPaintFlags(tvCrearCue.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvOlvideContra.setPaintFlags(tvOlvideContra.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
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