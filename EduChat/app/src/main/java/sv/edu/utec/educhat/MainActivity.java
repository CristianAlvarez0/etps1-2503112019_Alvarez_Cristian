package sv.edu.utec.educhat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        SQLiteOpenHelper admin = new sv.edu.utec.educhat.BaseDatos.SQLiteOpenHelper(MainActivity.this);
        SQLiteDatabase db =admin.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Error en crear la Base de datos", Toast.LENGTH_LONG).show();
        }



        //INSERTAR DATOS EN LA TABLA DE USUARIOS
        btIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteOpenHelper admin = new sv.edu.utec.educhat.BaseDatos.SQLiteOpenHelper(MainActivity.this);
                SQLiteDatabase db = admin.getWritableDatabase();

                String usuario = etUsu.getText().toString();
                String contraseña = etPass.getText().toString();

                // Verificar si los campos están vacíos
                if (usuario.isEmpty() || contraseña.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa usuario y contraseña", Toast.LENGTH_SHORT).show();
                    return; // Salir del método onClick sin realizar la consulta
                }

                // Consulta SQL para verificar si los datos son correctos
                String query = "SELECT * FROM usuarios WHERE NombreUSU = ? AND Pass = ?";
                Cursor cursor = db.rawQuery(query, new String[]{usuario, contraseña});

                if (cursor.moveToFirst()) {
                    startActivity(new Intent(MainActivity.this, PantallaPrincipal.class));
                } else {
                    // Los datos no son correctos, muestra un mensaje de error
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
                db.close();
            }
        });


        //SUBRRAYAR TEXTO
        tvCrearCue.setPaintFlags(tvCrearCue.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvOlvideContra.setPaintFlags(tvOlvideContra.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    public void PantallaRegistro(View v){
        Intent intento=new Intent(this,PantallaRegistro.class);
        startActivity(intento);

    }



}