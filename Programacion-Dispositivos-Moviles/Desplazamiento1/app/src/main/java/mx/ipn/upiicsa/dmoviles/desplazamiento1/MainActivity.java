package mx.ipn.upiicsa.dmoviles.desplazamiento1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        cargaDatos();
    }

    private void inicializaComponentes(){
        txt1 = (TextView) findViewById(R.id.txt1);
    }

    private void cargaDatos(){
        String s = "";
        for (int i=1; i<=200; i++){
            s += i + "\n";
        }
        txt1.setText(s);
    }
}
