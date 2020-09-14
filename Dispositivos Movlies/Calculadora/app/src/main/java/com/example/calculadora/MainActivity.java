package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        cargaDatos();
    }

    private void inicializaComponentes() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        listView1 = (ListView) findViewById(R.id.listView1);
    }

    private void cargaDatos(){
        String[] tablas = new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tablas);
        spinner1.setAdapter(adp);
    }

    public void button1_click(View sender){
        int n = Integer.parseInt(spinner1.getSelectedItem().toString());
        String[] arr = new String[10];
        for (int i=1; i<=10; i++) {
            arr[i-1] = n + " x " + i + " = " + (n*i);
        }
        ArrayAdapter adp2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr);
        listView1.setAdapter(adp2);
    }


}
