package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spiner;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        cargaDatos();
    }

    private void inicializaComponentes() {
        spiner = (Spinner) findViewById(R.id.spinner);
        listView = (ListView) findViewById(R.id.listView);
    }

    private void cargaDatos() {
        String[] datos = new String[]{
            "Sopes", "Chilaquiles", "Tamales", "Alambres", "Tostada", "Elotes", "Pizza", "Vikingo", "Guajolota", " Torta", "Atun", "Tacos", "Empanadas", "Jokeis"
        };
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, datos);
        spiner.setAdapter(adp);
        listView.setAdapter(adp);
    }

    public void button1_click(View sender){
        String valor = spiner.getSelectedItem().toString();
        Toast.makeText(this, valor, Toast.LENGTH_SHORT).show();
    }
}
