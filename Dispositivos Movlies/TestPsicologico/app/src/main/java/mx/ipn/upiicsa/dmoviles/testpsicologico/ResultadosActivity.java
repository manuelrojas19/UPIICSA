package mx.ipn.upiicsa.dmoviles.testpsicologico;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;

import mx.ipn.upiicsa.dmoviles.testpsicologico.model.AuxSQLite;

public class ResultadosActivity extends AppCompatActivity {
    ListView listView;
    TextView lblInstruccion;
    int position;
    ArrayList<String[]> preguntas = new ArrayList();
    String tipoTest;
    String preguntasTestTabla;
    String respAB[] = new String[4];
    Integer respuestasTestNum[] = new Integer[15];
    Integer respuestasTestABNum[] = new Integer[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        initComponents();
        loadData();
        cargaDatos();
    }


    private void loadData() {
        AuxSQLite cnx = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cnx.getReadableDatabase();
        String query = "select * from " + preguntasTestTabla;
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                String[] temp = new String[]{
                        c.getString(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4), c.getString(5)
                };
                preguntas.add(temp);
            } while (c.moveToNext());
        }
        cnx.close();
    }

    public void initComponents() {
        listView = (ListView)findViewById(R.id.list_res);
        lblInstruccion = (TextView) findViewById(R.id.lblInstruccion);
        position = getIntent().getIntExtra("position", 1);
        tipoTest = getIntent().getStringExtra("tipo_test");
        preguntasTestTabla = getIntent().getStringExtra("preguntasTabla");
        position++;
    }

    public void cargaDatos() {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getResultadosTest());
        listView.setAdapter(adapter);
        if (tipoTest.equals("respuestas")) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    long a = parent.getItemIdAtPosition(position) + 1;
                    int i = (int)a;
                    alertView("Resultado lamina " + i, message(i));

                }
            });
        } else {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    alertView("Resultado", resultadoABMessage());
                }
            });
        }
    }

    public String message(int i) {
        String message = "";
        switch (i) {
            case 1:
                message += "La lamina 1 representa la capacidad que tiene un individio para enfrentar nuevas situaciones";
                if (respuestasTestNum[1] == 1) {
                    message += " en este caso tu respuesta sugiere que tienes una buena capacidad de aceptacion al enfrentar situaciones nuevas";
                }
                else if (respuestasTestNum[1] == 2) {
                    message += " en este caso tu respuesta sugiere que puedes presentar algunos niveles de paranoia o estres al enfrentar nuevas situaciones, dependiendo del tamaño del animal que identificaste es relativo a los niveles que puedes presentar.";
                }
                else if (respuestasTestNum[1] == 3) {
                message += " en este caso tu respuesta podria sugerir la presencia de transtornos mas graves relacionados con la paranoia, estres o ansiedad que afectan el como enfrentas a nuevas situaciones.";
                }
                else if (respuestasTestNum[1] == 4) {
                message += " en este caso tu respuesta sugiere que presentas gran dificulatad a la hora de enfrentar nuevas situaciones.";
                }
            break;
            case 2:
                message += "La lamina 2 representa como son las relaciones interpersonales de un individuo";
                if (respuestasTestNum[2] == 1) {
                    message += " en este caso tu respuesta sugiere que puedes ser algo tímido a la hora de relacionarte con los demás.";
                }
                else if (respuestasTestNum[2] == 2) {
                    message += " en este caso tu respuesta sugiere que tienes facilidad para relacionarte con los demás.";
                }
                else if (respuestasTestNum[2] == 3) {
                    message += " en este caso tu respuesta sugiere que te cuesta trabajo relacionarte con los demás, dependiendo de la emocion que hayas percibido esto puede indicar como te desenvuelves con los demas.";
                }
                else if (respuestasTestNum[2] == 4) {
                    message += " en este caso tu respuesta sugiere que es muy dificil para ti el poder relacionarte con los demás.";
                }
                break;
            case 3:
                message += "La lamina 3 representa la percepcion hacia las personas y evalua dependiendo la respuesta la identidad sexual";
                if (respuestasTestNum[3] == 1) {
                    message += " en este caso tu respuesta sugiere en primer instancia de que presentas dificultades a la hora de escuchar o ponerte en los zapatos de los demas";
                }
                else if (respuestasTestNum[3] == 2) {
                    message += " en este caso tu respuesta sugiere que eres una persona empatica, dependiendo si en las figuras humanas que percibistes logras identificar el genero al que pertenecen este es un indicador de tus preferencias.";
                }
                else if (respuestasTestNum[3] == 3) {
                    message += " en este caso tu respuesta sugiere que te cuesta trabajo ser empatico con los demas.";
                }
                else if (respuestasTestNum[3] == 4) {
                    message += " en este caso tu respuesta sugiere que es muy dificil para ti el poder pensar en los demas, poniendote a ti en primer plano antes que a los demas.";
                }
                break;
            case 4:
                message += "La lamina 4 representa la percepcion hacia las figuras de autoridad";
                if (respuestasTestNum[4] == 1) {
                    message += " en este caso tu respuesta sugiere que guardas respeto a figuras de autoridad y las consideras superiores a ti.";
                }
                else if (respuestasTestNum[4] == 2) {
                    message += " en este caso tu respuesta sugiere que consideras a las personas de autoridad semejantes a ti pero no las consideras superiores a ti.";
                }
                else if (respuestasTestNum[4] == 3) {
                    message += " en este caso tu respuesta dependiendo la emocion que te genere podrian ser las emociones que te generan las figuras de autoridad.";
                }
                else if (respuestasTestNum[4] == 4) {
                    message += " en este caso tu respuesta sugiere que sueles no respetar a las figuras de autoriad presentas cierto grado de rebeldia hacia ellas.";
                }
                break;
            case 5:
                message += "La lamina 5 representa la integridad psiquica del individuo y como se apega a lo obvio";
                if (respuestasTestNum[5] == 1) {
                message += " en este caso tu respuesta sugiere que tienes una buena integridad psíquica.";
            }
                else if (respuestasTestNum[5] == 2) {
                message += " en este caso tu respuesta sugiere que no te apegas mucho a lo obvio, posees una mente mas imaginativa de lo usual.";
            }
            else if (respuestasTestNum[5] == 3) {
                message += " en este caso tu respuesta sugiere que eres padeces de algo de estrés o ansiedad";
            }
            else if (respuestasTestNum[5] == 4) {
                message += " en este caso tu respuesta sugiere que podrias presentar cierto grado de paranoia";
            }
            break;
            case 6:
                message += "La lamina 6 representa la relacion materna del individuo, lo cual a su vez refleja el comportamiento con las figuras de autoridad";
                if (respuestasTestNum[6] == 1) {
                    message += " en este caso tu respuesta sugiere que tienes una buena relación con la persona que consideras tu figura materna y no no tienes conflictos con las figuras de autoridad.";
                }
                else if (respuestasTestNum[6] == 2) {
                    message += " en este caso tu respuesta sugiere tienes algún grado de conflicto con tu figura materna.";
                }
                else if (respuestasTestNum[6] == 3) {
                    message += " en este caso tu respuesta sugiere que no entiendes del todo a tu figura materna, dependiendo de la emoción puede ser como es tu relación con ella";
                }
                else if (respuestasTestNum[6] == 4) {
                    message += " en este caso tu respuesta sugiere que podrias presentar algún conflicto con tu figura materna y por ende conflictos con las figuras de autoridad";
                }
                break;
            case 7:
                message += "La figura 7 representa como responde el individuo a lo afectivo y así mismo su apego a la realidad";
              if (respuestasTestNum[7] == 1) {
                    message += " en este caso tu respuesta sugiere que eres una persona apegada a la realidad y mantienes relaciones sanas.";
                }
                else if (respuestasTestNum[7] == 2) {
                    message += " en este caso tu respuesta sugiere que tiendes a ser algo infantil, algo despegado de la realidad y tus relaciones no son del todo satisfactorias.";
                }
                else if (respuestasTestNum[7] == 3) {
                    message += " en este caso tu respuesta sugiere que no manejas muy bien tus relaciones afectas, estas algo desapegado de la realidad";
                }
                else if (respuestasTestNum[7] == 4) {
                    message += " en este caso tu respuesta sugiere que te encuentras desapegado de la realidad y prescencia de ansiedad";
                }
                break;
            case 8:
                message += "La lamina 8 representa como el sujeto enfrenta situaciones de angustia o frustración";
                if (respuestasTestNum[8] == 1) {
                    message += " en este caso tu respuesta sugiere que eres una persona que puede soportar la frustación.";
                }
                else if (respuestasTestNum[8] == 2) {
                    message += " en este caso tu respuesta sugiere que no soportas del todo la frustración pero puedes manejarlo.";
                }
                else if (respuestasTestNum[8] == 3) {
                    message += " en este caso tu respuesta sugiere que tiendes a ignorar las situaciones que podrian generarte frustración";
                }
                else if (respuestasTestNum[8] == 4) {
                    message += " en este caso tu respuesta sugiere que tienes dificultad al momento de manejar la angustia o frsutracion";
                }
                break;
            case 9:
                message += "La lamina 9 representa como el individuo organiza sus ideas y pensamientos";
                if (respuestasTestNum[9] == 1) {
                message += " en este caso tu respuesta sugiere que eres una persona sana capaz de organizar sus pensamientos de manera adecuada.";
            }
                else if (respuestasTestNum[9] == 2) {
                message += " en este caso tu respuesta sugiere que sabes organizar tus ideas y pensamientos, sin embargo sueles ser impulsivo";
            }
            else if (respuestasTestNum[9] == 3) {
                message += " en este caso tu respuesta sugiere que no eres capaz de organizar tus ideas de manera coherente, tiendes a ser impulsivo";
            }
            else if (respuestasTestNum[9] == 4) {
                message += " en este caso tu respuesta sugiere la presencia de transtorno, estrés o ansiedad";
            }
            break;

        }
        return  message;
    }

    private void alertView( String title, String message ) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }

    public String resultadoABMessage() {
        String message = "";
        Integer resultado = 0;
        for (int i = 1; i < 15; i++) {
            if (respuestasTestABNum[i] == 1 || respuestasTestABNum [i] == 2) {
                resultado++;
            }
        }
        if (resultado > 4) {
            message += "Eres una persona que toma el trabajo como su centro vital, constantemente buscas involucrarte en proyectos que tienen fechas limites " +
                    "constantemente estas mirando el relog y te impacientas ante los obstaculos para alcanzar tus metas, buscas triunfra y sobresalir " +
                    "eres muy comprometido con lo que te propones";
        } else {
            message += "Eres menos vulnerable a sufir ansiedad que otras personas, no te muestras ambicioso ni dominante"
                    + "dejas que las cosas sigan su cauce sin preocuparte en exceso, generalmente tienes un temperamento templado"
                    + "sueles ser informal en ocaciones, seguro de ti mismo, relajado y alegre, sabes escuchar y trasnmites menos señales de ansiedad"
                    + "te afecta menos el estres y no eres competitivo";
        }
        return message;
    }

    public List<String> getResultadosTest() {
        List<String> stringListTest = new ArrayList<>();
        AuxSQLite cmd = new AuxSQLite(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = cmd.getReadableDatabase();
        if(db != null) {
            Cursor c = db.rawQuery("SELECT * FROM "+ tipoTest + " where id=" + position, null);
            if(tipoTest.equals("respuestas")) {
                lblInstruccion.setText("Haz click en cada respuesta para conocer los resultados del test");
            } else {
                lblInstruccion.setText("Haz click en cualquier respuesta para conocer los resultados del test");
            }
            if (c.moveToFirst()) {
                do {
                    if(tipoTest.equals("respuestas")) {
                        respuestasTestNum[1] = c.getInt(1);
                        respuestasTestNum[2] = c.getInt(2);
                        respuestasTestNum[3] = c.getInt(3);
                        respuestasTestNum[4] = c.getInt(4);
                        respuestasTestNum[5] = c.getInt(5);
                        respuestasTestNum[6] = c.getInt(6);
                        respuestasTestNum[7] = c.getInt(7);
                        respuestasTestNum[8] = c.getInt(8);
                        respuestasTestNum[9] = c.getInt(9);
                        stringListTest.add("Lámina 1 Respuesta: " + preguntas.get(0)[respuestasTestNum[1]+1]);
                        stringListTest.add("Lámina 2 Respuesta: " + preguntas.get(1)[respuestasTestNum[2]+1]);
                        stringListTest.add("Lámina 3 Respuesta: " + preguntas.get(2)[respuestasTestNum[3]+1]);
                        stringListTest.add("Lámina 4 Respuesta: " + preguntas.get(3)[respuestasTestNum[4]+1]);
                        stringListTest.add("Lámina 5 Respuesta: " + preguntas.get(4)[respuestasTestNum[5]+1]);
                        stringListTest.add("Lámina 6 Respuesta: " + preguntas.get(5)[respuestasTestNum[6]+1]);
                        stringListTest.add("Lámina 7 Respuesta: " + preguntas.get(6)[respuestasTestNum[7]+1]);
                        stringListTest.add("Lámina 8 Respuesta: " + preguntas.get(7)[respuestasTestNum[8]+1]);
                        stringListTest.add("Lámina 9 Respuesta: " + preguntas.get(8)[respuestasTestNum[9]+1]);
                    }
                    else {
                        respuestasTestABNum[1] = c.getInt(1);
                        respuestasTestABNum[2] = c.getInt(2);
                        respuestasTestABNum[3] = c.getInt(3);
                        respuestasTestABNum[4] = c.getInt(4);
                        respuestasTestABNum[5] = c.getInt(5);
                        respuestasTestABNum[6] = c.getInt(6);
                        respuestasTestABNum[7] = c.getInt(7);
                        respuestasTestABNum[8] = c.getInt(8);
                        respuestasTestABNum[9] = c.getInt(9);
                        respuestasTestABNum[10] = c.getInt(10);
                        respuestasTestABNum[11] = c.getInt(11);
                        respuestasTestABNum[12] = c.getInt(12);
                        respuestasTestABNum[13] = c.getInt(13);
                        respuestasTestABNum[14] = c.getInt(14);
                        stringListTest.add("Pregunta 1: " + preguntas.get(0)[1] + " Respuesta: " + preguntas.get(0)[respuestasTestABNum[1]+1]);
                        stringListTest.add("Pregunta 2: " + preguntas.get(1)[1] + " Respuesta: " + preguntas.get(1)[respuestasTestABNum[2]+1]);
                        stringListTest.add("Pregunta 3: " + preguntas.get(2)[1] + " Respuesta: " + preguntas.get(2)[respuestasTestABNum[2]+1]);
                        stringListTest.add("Pregunta 4: " + preguntas.get(3)[1] + " Respuesta: " + preguntas.get(3)[respuestasTestABNum[4]+1]);
                        stringListTest.add("Pregunta 5: " + preguntas.get(4)[1] + " Respuesta: " + preguntas.get(4)[respuestasTestABNum[5]+1]);
                        stringListTest.add("Pregunta 6: " + preguntas.get(5)[1] + " Respuesta: " + preguntas.get(5)[respuestasTestABNum[6]+1]);
                        stringListTest.add("Pregunta 7: " + preguntas.get(6)[1] + " Respuesta: " + preguntas.get(6)[respuestasTestABNum[7]+1]);
                        stringListTest.add("Pregunta 8: " + preguntas.get(7)[1] + " Respuesta: " + preguntas.get(7)[respuestasTestABNum[8]+1]);
                        stringListTest.add("Pregunta 9: " + preguntas.get(8)[1] + " Respuesta: " + preguntas.get(8)[respuestasTestABNum[9]+1]);
                        stringListTest.add("Pregunta 10: " + preguntas.get(9)[1] + " Respuesta: " + preguntas.get(9)[respuestasTestABNum[10]+1]);
                        stringListTest.add("Pregunta 11: " + preguntas.get(10)[1] + " Respuesta: " + preguntas.get(10)[respuestasTestABNum[11]+1]);
                        stringListTest.add("Pregunta 12: " + preguntas.get(11)[1] + " Respuesta: " + preguntas.get(11)[respuestasTestABNum[12]+1]);
                        stringListTest.add("Pregunta 13: " + preguntas.get(12)[1] + " Respuesta: " + preguntas.get(12)[respuestasTestABNum[13]+1]);
                        stringListTest.add("Pregunta 14: " + preguntas.get(13)[1] + " Respuesta: " + preguntas.get(12)[respuestasTestABNum[14]+1]);

                    }
                } while(c.moveToNext());
            }
            c.close();
            db.close();
        }
        return stringListTest;
    }

}
