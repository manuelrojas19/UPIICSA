package mx.ipn.upiicsa.dmoviles.widgetsprogramaticos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nombre;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);

        //Vista
        ScrollView view = new ScrollView(this);
        view.setLayoutParams(params);

        //Capa
        LinearLayout capa = new LinearLayout(this);
        capa.setOrientation(LinearLayout.VERTICAL);
        capa.setLayoutParams(params);

        //Artilugios de texto
        TextView etiqueta = new TextView(this);

        Button btn = new Button(this);
        texto = new EditText(this);
        etiqueta.setText("Tu nombre");
        capa.addView(etiqueta);
        texto.setText("");
        capa.addView(texto);
        btn.setText("Saludar!!!");

        //Asignacion de los elementos ordenados en Vista, Capa, Artilugio
        capa.addView(btn);
        view.addView(capa);
        setContentView(view);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nombre = texto.getText().toString();
                toast();
            }
        });

    }

    private void toast(){
        Toast.makeText(this, "Hola " + nombre, Toast.LENGTH_SHORT).show();
    }
}
