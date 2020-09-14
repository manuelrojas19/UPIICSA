package com.example.calculosalario;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPagoHora, txtHorasTrabajadas;
    TextView lblSalarioBruto, lblDescuento, lblNeto;
    double hrsTrabajadas, pagoHora,bruto, desc, neto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        txtNombre = findViewById(R.id.txtNombre);
        txtHorasTrabajadas = findViewById(R.id.txtHrsTrabajas);
        txtPagoHora = findViewById(R.id.txtPagoHora);
        lblSalarioBruto = findViewById(R.id.lblSalarioBruto);
        lblDescuento = findViewById(R.id.lblDescuento);
        lblNeto = findViewById(R.id.lblNeto);

    }

    public void btnCalcular_click(View sender){
        hrsTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText().toString());
        pagoHora = Double.parseDouble(txtPagoHora.getText().toString());
        bruto = hrsTrabajadas * pagoHora;
        desc = bruto*0.1;
        neto = bruto-desc;
        String msg1 = "Salario bruto: $" + bruto;
        String msg2 = "Descuento (10%): $" + desc;
        String msg3 = "Salario Neto $" + neto;
        lblSalarioBruto.setText(msg1);
        lblDescuento.setText(msg2);
        lblNeto.setText(msg3);
    }
}
