package sv.edu.utec.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edtValor, edtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtValor =findViewById(R.id.edtTabla);
        edtResultado= findViewById(R.id.edtMtabla);
    }
    public void Tabla(View v){
        int valtabla=Integer.parseInt(edtValor.getText().toString());
        int resultados;
        String Resultado="";
        edtResultado.setText(Resultado);
        for (int y=0;y<=10;y++){
            resultados=valtabla*y;
            Resultado=String.valueOf(resultados);
            edtResultado.append(valtabla+"*"+y+"="+Resultado+"\n");
        }


    }
}