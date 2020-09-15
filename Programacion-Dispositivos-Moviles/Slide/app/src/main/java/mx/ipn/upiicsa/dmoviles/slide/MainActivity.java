package mx.ipn.upiicsa.dmoviles.slide;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
        capa.setBackgroundColor(Color.GREEN);

        //Artilugios de texto
        TextView etiqueta = new TextView(this);
        EditText texto = new EditText(this);
        etiqueta.setText("Texto");
        capa.addView(etiqueta);
        texto.setText("Valor");
        capa.addView(texto);

        //Asignacion de los elementos ordenados en Vista, Capa, Artilugio
        view.addView(capa);
        setContentView(view);

    }
}