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

public class FactorsActivity extends AppCompatActivity {

    TextView lblPregunta;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    RadioGroup radioGroup1;

    ArrayList<String[]> datos = new ArrayList();

    Integer[] respuestas = new Integer[15];
    int index = 1;
    int numTest = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        initComponents();
        loadData();
        cargarIndice();
        cargarPreguntaPrefs();
        cargarPregunta();
    }

    private void initComponents() {
        lblPregunta = (TextView) findViewById(R.id.lblPreguntaR);
        radioButton1 = (RadioButton) findViewById(R.id.radio1R);
        radioButton2 = (RadioButton) findViewById(R.id.radio2R);
        radioButton3 = (RadioButton) findViewById(R.id.radio3R);
        radioButton4 = (RadioButton) findViewById(R.id.radio4R);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1R);
    }

    private void loadData() {
        AuxSQLite cnx = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cnx.getReadableDatabase();
        String query = "select * from personalidadABPreguntas";
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                String[] temp = new String[]{
                        c.getString(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4) , c.getString(5)
                };
                datos.add(temp);
            } while (c.moveToNext());
        }
        cnx.close();
    }

    private void cargarIndice() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        index = prefs.getInt("indexAB", 1);
    }

    private void cargarPreguntaPrefs() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        for(int i = 1; i<=index; i ++) {
            String pregunta = "respuestaAB" + i;
            respuestas[i] = prefs.getInt(pregunta, 1);
        }
    }

    private void cargarPregunta() {
        this.lblPregunta.setText(datos.get(index - 1)[1]);
        this.radioButton1.setText(datos.get(index - 1)[2]);
        this.radioButton2.setText(datos.get(index - 1)[3]);
        this.radioButton3.setText(datos.get(index - 1)[4]);
        this.radioButton4.setText(datos.get(index - 1)[5]);
    }

    private void guardarRespuestas() {
        switch (radioGroup1.getCheckedRadioButtonId()) {
            case R.id.radio1R:
                respuestas[index] = 1;
                break;
            case R.id.radio2R:
                respuestas[index] = 2;
                break;
            case R.id.radio3R:
                respuestas[index] = 3;
                break;
            case R.id.radio4R:
                respuestas[index] = 4;
                break;
        }
    }

    private void guardarPreguntasPrefs() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        String pregunta = "respuestaAB" + index;
        edit.putInt(pregunta, respuestas[index]);
        edit.commit();
    }

    private void guardarIndice() {
        SharedPreferences prefs = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt("indexAB", index);
        edit.commit();

    }

    private void guardarRespuestasTest() {
        AuxSQLite cmd = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cmd.getWritableDatabase();
        if (db != null) {
            String sql = "INSERT INTO personalidadABRespuestas (id, respuesta1, respuesta2, respuesta3, respuesta4, " +
                    "respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, " +
                    "respuesta10, respuesta11, respuesta12, respuesta13, respuesta14)" +
                    "VALUES (NULL, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?)";
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
            stmt.bindLong(10, respuestas[10]);
            stmt.bindLong(11, respuestas[11]);
            stmt.bindLong(12, respuestas[12]);
            stmt.bindLong(13, respuestas[13]);
            stmt.bindLong(14, respuestas[14]);
            stmt.execute();
        }
        db.close();
    }

    private void guardarResultadoTest() {
        AuxSQLite cmd = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cmd.getWritableDatabase();
        if(db != null) {
            db.execSQL("INSERT INTO resultados (id, fecha, tipo_test, id_respuestas) " +
                    "VALUES (null, datetime(), 'PersonalidadAB', '" + numTest + "')");
        }
        db.close();
    }

    public void btnSiguiente_clickR(View sender) {
        guardarRespuestas();
        guardarPreguntasPrefs();
        index++;
        if (index < 15) {
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

}
