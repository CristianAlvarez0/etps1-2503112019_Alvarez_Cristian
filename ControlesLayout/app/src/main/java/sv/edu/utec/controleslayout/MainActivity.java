package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Spinner spPais;
EditText etNombres,etApellidos,etInfo;
RadioButton rbFem,rbMas,rbOtr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombres=findViewById(R.id.edtNombres);
        etApellidos=findViewById(R.id.edtApellidos);
        etInfo=findViewById(R.id.editTextTextMultiLine);
        spPais=findViewById(R.id.spnPais);
        /* forma 1
        spPais.setSelection(0, false);
        String[]opciones={"Seleccione un Pais","Guatemala","El Salvador","Honduras","Nicaragua","Costa Rica","Panama"};
       ArrayAdapter<String> adaptador=
                new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
        spPais.setAdapter(adaptador);
        */

        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){

            public View getView(int posicion,View contenido, ViewGroup parent){
                View vista=super.getView(posicion,contenido,parent);
                if(posicion==getCount()){
                    ((TextView)vista.findViewById(android.R.id.text1)).setText("");
                    ((TextView)vista.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }
                return vista;
            }

            public int getCount(){
                return super.getCount()-1;
            }
        };

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptador.add("Guatemala");
        adaptador.add("El Salvador");
        adaptador.add("Honduras");
        adaptador.add("Nicaragua");
        adaptador.add("Panama");
        adaptador.add("Costa Rica");
        adaptador.add("Seleccione un Pais");//este es el elemento a quitar del spinner
        spPais.setAdapter(adaptador);
        spPais.setSelection(adaptador.getCount());

    }



    public void Almacenar(View v){
        String datos="";
        String seleccion = spPais.getSelectedItem().toString();

        if(seleccion.equals("Seleccione un Pais")){
            datos="No selecciono ningun Pais";
            etInfo.append(datos);
        }
        else if(seleccion.equals("Guatemala")){
                datos="Guatemala";
            etInfo.append(datos);
            }
        else if(seleccion.equals("El Salvador")){
            datos="El Salvador";
            etInfo.append(datos);
        }
        else if(seleccion.equals("Honduras")){
            datos="Honduras";
            etInfo.append(datos);
        }
        //etInfo.append("datos");
//08/02/2023
        }
    }

