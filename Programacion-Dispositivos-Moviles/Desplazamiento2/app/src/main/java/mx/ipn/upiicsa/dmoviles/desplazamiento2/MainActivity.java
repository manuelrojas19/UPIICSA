package mx.ipn.upiicsa.dmoviles.desplazamiento2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);

        ScrollView view = new ScrollView(this);
        view.setLayoutParams(params);

        LinearLayout capa = new LinearLayout(this);
        capa.setOrientation(LinearLayout.VERTICAL);
        capa.setLayoutParams(params);

        for (int i=1; i<=100; i++){
            Button btn = new Button(this);
            btn.setText("Botón " + i);
            btn.setId(i);
            btn.setOnClickListener(listenerBtn);
            capa.addView(btn);
        }
        view.addView(capa);
        setContentView(view);
    }

    private View.OnClickListener listenerBtn = new View.OnClickListener() {
        public void onClick(View sender) {
            toast(sender.getId());
        }
    };

    private void toast(int i){
        Toast.makeText(this, "Hola: Botón " + i + " presionado", Toast.LENGTH_SHORT).show();
    }
}
