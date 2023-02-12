package sv.edu.utec.proyintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText etval1,etval2;
Button btCalculo;
TextView twresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etval1=findViewById(R.id.edtValor1);
        etval2=findViewById(R.id.edtValor2);
        twresultado=findViewById(R.id.txvResultado);


    }
    //void                      --> metodos sin retorno
    //int, string, double, etc.  --> metodos con retorno
    public void Suma(View view)
    {
        double dato1, dato2, resultado;

        dato1=Double.parseDouble(etval1.getText().toString());
        dato2=Double.parseDouble(etval2.getText().toString());
        resultado=dato1+dato2;
        twresultado.setText("El resultado es"+String.valueOf(resultado));
    }
}