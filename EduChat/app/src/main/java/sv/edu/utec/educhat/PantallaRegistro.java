package sv.edu.utec.educhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaRegistro extends AppCompatActivity {

    TextView RegresaLoging;
    Button btnIngresoLoging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        RegresaLoging = findViewById(R.id.link_textview);
        btnIngresoLoging = findViewById(R.id.btnIngreso);

        btnIngresoLoging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaRegistro.this, MainActivity.class);
                startActivity(intent);
            }
        });




        RegresaLoging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaRegistro.this, MainActivity.class);
                startActivity(intent);
            }
        });
        RegresaLoging.setPaintFlags(RegresaLoging.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);



    }
}