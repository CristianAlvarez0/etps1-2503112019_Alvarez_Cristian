package sv.edu.utec.proyectolistener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
Button btnPrincipal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrincipal=findViewById(R.id.btnListener);

        btnPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(), Principal.class);
                startActivity(intento);
            }
        });
    }

    public void Pantalla(View v){
        Intent intento=new Intent(this,Pantalla3.class);
        startActivity(intento);
    }
    public void Salir(View v){
        finish();
    }

}