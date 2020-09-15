package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaComponentes();
        cargaDatos();
    }

    private void cargaDatos() {
        //leer las preferencias de usuario
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        String valor = prefs.getString("color", "");

        if (!valor.equals("")){
            Toast.makeText(this, valor, Toast.LENGTH_LONG).show();
        }
    }

    private void inicializaComponentes(){
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        editText1 = (EditText)findViewById(R.id.editText1);
    }

    public void cambiaColor(View view){
        String color = editText1.getText().toString();
        Toast.makeText(this, color,  Toast.LENGTH_LONG).show();
        this.mainLayout.setBackgroundColor(Color.BLUE);

        //Guardar color
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("color", color);
        edit.commit();
    }
}
