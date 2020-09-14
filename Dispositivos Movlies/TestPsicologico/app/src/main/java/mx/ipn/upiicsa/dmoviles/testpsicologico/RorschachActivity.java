package mx.ipn.upiicsa.dmoviles.testpsicologico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import mx.ipn.upiicsa.dmoviles.testpsicologico.model.AuxSQLite;

public class RorschachActivity extends AppCompatActivity {

    TextView lblPregunta;
    ImageView imageView;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    RadioGroup radioGroup1;

    ArrayList<String[]> datos = new ArrayList();

    Integer[] respuestas = new Integer[10];
    int index = 1;
    int[] images = new int[10];
    int numTest = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rorschach);
        initComponents();
        loadData();
        cargarIndice();
        cargarPreguntaPrefs();
        getIndexImage();
        cargarPregunta();
    }

    private void cargarPregunta() {
        this.imageView.setImageResource(images[index - 1]);
        this.lblPregunta.setText(datos.get(index - 1)[1]);
        this.radioButton1.setText(datos.get(index - 1)[2]);
        this.radioButton2.setText(datos.get(index - 1)[3]);
        this.radioButton3.setText(datos.get(index - 1)[4]);
        this.radioButton4.setText(datos.get(index - 1)[5]);
    }

    public void getIndexImage() {
        images[0] = R.drawable.rorschach_blot_01;
        images[1] = R.drawable.rorschach_blot_02;
        images[2] = R.drawable.rorschach_blot_03;
        images[3] = R.drawable.rorschach_blot_04;
        images[4] = R.drawable.rorschach_blot_05;
        images[5] = R.drawable.rorschach_blot_07;
        images[6] = R.drawable.rorschach_blot_08;
        images[7] = R.drawable.rorschach_blot_09;
        images[8] = R.drawable.rorschach_blot_10;
    }

    private void loadData() {
        AuxSQLite cnx = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cnx.getReadableDatabase();
        String query = "select * from preguntas";
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                String[] temp = new String[]{
                        c.getString(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4), c.getString(5)
                };
                datos.add(temp);
            } while (c.moveToNext());
        }
        cnx.close();
    }

    private void initComponents() {
        lblPregunta = (TextView) findViewById(R.id.lblPregunta);
        radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioButton2 = (RadioButton) findViewById(R.id.radio2);
        radioButton3 = (RadioButton) findViewById(R.id.radio3);
        radioButton4 = (RadioButton) findViewById(R.id.radio4);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        imageView = (ImageView) findViewById(R.id.imgRorschach);
    }

    private void guardarRespuestas() {
        switch (radioGroup1.getCheckedRadioButtonId()) {
            case R.id.radio1:
                respuestas[index] = 1;
                break;
            case R.id.radio2:
                respuestas[index] = 2;
                break;
            case R.id.radio3:
                respuestas[index] = 3;
                break;
            case R.id.radio4:
                respuestas[index] = 4;
                break;
        }
    }

    private void guardarRespuestasTest() {
        AuxSQLite cmd = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cmd.getWritableDatabase();
        if (db != null) {
            String sql = "INSERT INTO respuestas (id, respuesta1, respuesta2, respuesta3, respuesta4, " +
                    "respuesta5, respuesta6, respuesta7, respuesta8, respuesta9)" +
                    "VALUES (NULL, ? , ?, ?, ?, ?, ?, ?, ?, ?)";
            SQLiteStatement stmt = db.compileStatement(sql);
            stmt.bindLong(1, respuestas[1]);
            stmt.bindLong(2, respuestas[2]);
            stmt.bindLong(3, respuestas[3]);
            stmt.bindLong(4, respuestas[4]);
            stmt.bindLong(5, respuestas[5]);
            stmt.bindLong(6, respuestas[6]);
            stmt.bindLong(7, respuestas[7]);
            stmt.bindLong(8, respuestas[8]);
            stmt.bindLong(9, respuestas[9]);
            stmt.execute();
        }
        db.close();
    }

    private void guardarIndice() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt("index", index);
        edit.commit();

    }

    private void guardarPreguntasPrefs() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        String pregunta = "respuesta" + index;
        edit.putInt(pregunta, respuestas[index]);
        edit.commit();
    }

    private void cargarPreguntaPrefs() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        for(int i = 1; i<=index; i ++) {
            String pregunta = "respuesta" + i;
            respuestas[i] = prefs.getInt(pregunta, 1);
        }
    }

    private void cargarIndice() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        index = prefs.getInt("index", 1);
    }

    public void btnSiguiente_click(View sender) {
        guardarRespuestas();
        guardarPreguntasPrefs();
        index++;
        if (index < 10) {
            cargarPregunta();
            guardarIndice();
        } else {
            index = 1;
            guardarRespuestasTest();
            guardarResultadoTest();
            guardarIndice();
            Toast toast =
            Toast.makeText(getApplicationContext(),
                    "Test finalizado, consulta la pestaña de resultados para conocer los resultados de este test.", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
    }

    private void guardarResultadoTest() {
        AuxSQLite cmd = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cmd.getWritableDatabase();
        if(db != null) {
            db.execSQL("INSERT INTO resultados (id, fecha, tipo_test, id_respuestas) " +
                    "VALUES (null, datetime(), 'Rorscharch', '" + numTest + "')");
        }
        db.close();
    }
}
