package sv.edu.utec.educhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaRegistro extends AppCompatActivity {

    TextView RegresaLoging;
    Button btnIngresoLoging, btnRegistro;
    EditText etIngresarUsu, etCorreo, etPass, etConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        RegresaLoging = findViewById(R.id.link_textview);
        btnRegistro = findViewById(R.id.btnIngresarSignUp);
        btnIngresoLoging = findViewById(R.id.btnIngreso);
        etIngresarUsu = findViewById(R.id.edtIngresarUsuario);
        etCorreo = findViewById(R.id.edtCorreo);
        etPass = findViewById(R.id.edtContraseña);
        etConfirmPass = findViewById(R.id.edtConfirmarContra);


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteOpenHelper admin = new sv.edu.utec.educhat.BaseDatos.SQLiteOpenHelper(PantallaRegistro.this);
                SQLiteDatabase db =admin.getWritableDatabase();

                String nombre = etIngresarUsu.getText().toString();
                String correo = etCorreo.getText().toString();
                String pass = etPass.getText().toString();
                String confirmPass = etConfirmPass.getText().toString();

                if (nombre.isEmpty() || correo.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, completa todos los campos", Toast.LENGTH_LONG).show();
                    return;
                }
                // Validar que la contraseña y la confirmación coincidan
                if (!pass.equals(confirmPass)) {
                    Toast.makeText(getApplicationContext(), "La contraseña y la confirmación no coinciden", Toast.LENGTH_LONG).show();
                    return;
                }
                // Verificar si ya existe un usuario con el mismo nombre o correo
                String[] projection = {"NombreUSU", "correo"};
                String selection = "NombreUSU = ? OR correo = ?";
                String[] selectionArgs = {nombre, correo};
                Cursor cursor = db.query("usuarios", projection, selection, selectionArgs, null, null, null);

                if (cursor.moveToFirst()) {
                    // El usuario ya existe
                    Toast.makeText(getApplicationContext(), "Ya existe un usuario con el mismo nombre o correo", Toast.LENGTH_LONG).show();
                    cursor.close();
                    db.close();
                    return;
                }

                ContentValues informacion = new ContentValues();
                informacion.put("NombreUSU", nombre);
                informacion.put("correo", correo);
                informacion.put("Pass", pass);
                informacion.put("ConfirmPass", confirmPass);

                try {
                    db.insert("usuarios", null, informacion);
                    Toast.makeText(getApplicationContext(), "Se insertó el usuario", Toast.LENGTH_LONG).show();
                    db.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error al ingresar" + e.getCause(), Toast.LENGTH_LONG).show();
                }
            }
        });

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