package mx.ipn.upiicsa.dmoviles.tiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Double suma;
    Spinner spinner1;
    TextView lblNota;
    TextView lblPrecio;
    TextView txtTotal;
    ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        cargaDatos();
        nota();
    }

    private void inicializaComponentes() {
        suma = new Double(0.0);
        productos = new ArrayList<Producto>();
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        lblNota = (TextView) findViewById(R.id.lblNota);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
    }

    private void cargaDatos() {
        productos.add(new Producto("Chettos", 8.00));
        productos.add(new Producto( "Ruffles", 10.50));
        productos.add(new Producto( "Boing", 14.50));
        productos.add(new Producto( "Agua", 12.00));
        productos.add(new Producto( "Galletas", 14.00));
        productos.add(new Producto( "Sabritas", 8.50));
        productos.add(new Producto( "Coca", 8.00));
        productos.add(new Producto( "Jarrito", 7.50));
        productos.add(new Producto( "Atun", 6.00));
        productos.add(new Producto( "Maruchan", 5.00));

        String[] menu = new String[10];
        for (int i=1; i<=10; i++) {
            String x = productos.get(i-1).getProducto();
            menu[i-1] = x;
        }
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, menu);
        spinner1.setAdapter(adp);
    }

    public void nota() {
        spinner1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    String producto="";
                    String precio="";
                    public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id) {
                        producto+= spn.getItemAtPosition(posicion).toString() + "\n";
                        lblNota.setText(producto);
                        precio+= "$" + productos.get(posicion).getPrecio() + "\n";
                        lblPrecio.setText(precio);
                        suma+= productos.get(posicion).getPrecio();
                    }
                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });
    }

    public void button1_click(View sender) {
        txtTotal.setText("$" + suma.toString());
    }

}
