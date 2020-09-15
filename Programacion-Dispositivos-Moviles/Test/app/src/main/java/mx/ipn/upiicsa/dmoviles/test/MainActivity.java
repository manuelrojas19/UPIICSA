package mx.ipn.upiicsa.dmoviles.test;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView lblPregunta;
    RadioButton radioButton0, radioButton1, radioButton2, radioButton3;
    RadioGroup radioGroup1;
    ArrayList<String[]> datos = new ArrayList();
    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        loadData();
        loadQuestion();

    }

    private void loadQuestion() {
        if(index < 9)
            index++;
        this.lblPregunta.setText(datos.get(index)[1]);
        this.radioButton0.setText(datos.get(index)[2]);
        this.radioButton1.setText(datos.get(index)[4]);
        this.radioButton2.setText(datos.get(index)[6]);
        this.radioButton3.setText(datos.get(index)[8]);
    }

    private void loadData() {
        AuxSQLite cnx = new AuxSQLite(this, "base.sqlite3", null, 1);
        SQLiteDatabase db = cnx.getReadableDatabase();
        String query = "select * from preguntas";
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                String[] temp = new String[] {
                        c.getString(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4), c.getString(5),
                        c.getString(6), c.getString(7), c.getString(8),
                        c.getString(9)
                };
                datos.add(temp);
            } while (c.moveToNext());
        }
        cnx.close();
    }

    private void initComponents() {
        lblPregunta = (TextView)findViewById(R.id.lblPregunta);
        radioButton0 = (RadioButton)findViewById(R.id.radio0);
        radioButton1 = (RadioButton)findViewById(R.id.radio1);
        radioButton2 = (RadioButton)findViewById(R.id.radio2);
        radioButton3 = (RadioButton)findViewById(R.id.radio3);
        radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
    }

    public void btnSiguiente_click(View sender) {
        loadQuestion();
    }
}


