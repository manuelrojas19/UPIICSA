package mx.ipn.upiicsa.dmoviles.testpsicologico.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AuxSQLite extends SQLiteOpenHelper {


    public AuxSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE preguntas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "imagen TEXT NOT NULL, " +
                "resp1 TEXT NOT NULL, " +
                "resp2 TEXT NOT NULL, " +
                "resp3 TEXT NOT NULL, " +
                "resp4 TEXT NOT NULL, " +
                "resp5 TEXT NOT NULL);";
        db.execSQL(query);

        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 1','Figura de uno o varios animales (Animal pequeño como polilla, murcielago, etc)','Figura de uno o varios animales (Animal de gran tamaño como: lobo, leon, etc)','Figura abstracta (La percibo como alguna emocion o sentimiento)','No logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 2','Figura de uno o mas animales','Figura de uno o mas seres humanos','Figura abstracta (La percibo como alguna emocion o sentimiento)','No logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 3','Figura de uno o mas animales','Figura de uno o mas seres humanos','Figura abstracta (La percibo como alguna emocion o sentimiento)','No logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 4','Figura(s) animal','Figura(s) humana','Figura abstracta (La percibo como alguna emocion o sentimiento)','No logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 5','Mariposa o Murcielago','Figura abstracta','Figuras humanas','Otra o no logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 6','Caras o figuras humanas','Paisajes, montañas, nubes, etc','Figura abstracta (La percibo como alguna emocion o sentimiento)','No logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 7','Figuras de dos animales pequeños','Figuras de mas de dos animales','Figura abstracta (La percibo como alguna emocion o sentimiento)','No logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 8','Humo, fuego','Figuras humanas','Figura abstracta (La percibo como alguna emocion o sentimiento)','No logro identificarla', 'Otra');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Lámina 9','Cangrejo, figuras marinas o de otra índole exparcidas','Figuras humanas','Humo','No logro identificarla', 'Otra');";
        db.execSQL(query);

        query = "CREATE TABLE respuestas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "respuesta1 INTEGER NOT NULL, " +
                "respuesta2 INTEGER NOT NULL, " +
                "respuesta3 INTEGER NOT NULL, " +
                "respuesta4 INTEGER NOT NULL, " +
                "respuesta5 INTEGER NOT NULL, " +
                "respuesta6 INTEGER NOT NULL, " +
                "respuesta7 INTEGER NOT NULL, " +
                "respuesta8 INTEGER NOT NULL, " +
                "respuesta9 INTEGER NOT NULL);";
        db.execSQL(query);

        query = "CREATE TABLE resultados (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha DATETIME NOT NULL, " +
                "tipo_test TEXT NOT NULL, " +
                "id_respuestas INTEGER NOT NULL, " +
                "FOREIGN KEY(id_respuestas) REFERENCES respuestas(id));";
        db.execSQL(query);

        query = "CREATE TABLE personalidadABPreguntas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "pregunta TEXT NOT NULL, " +
                "resp1 TEXT NOT NULL, " +
                "resp2 TEXT NOT NULL, " +
                "resp3 TEXT NOT NULL, " +
                "resp4 TEXT NOT NULL);";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'No me gusta esperar a que otras personas terminen su trabajo para que yo pueda proseguir el mio','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Odio tener que esperar formado en la fila','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'La gente me dice que me suelo irritar con facilidad','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Siempre que puedo trato de hacer que mis actividades sean competitivas','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Suelo emprender el trabajo que debo hacer antes de saber bien procedimiento deberia ser el mejor','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Cuando salgo de vacaciones llevo el trabajo conmigo','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Cuando me equivoco es por comenzar a hacer un trabajo antes de planearlo','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Me siento culpable cuando dejo de trabajar para tomar un descanso','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'La gente dice que tengo mal carácter cuando estoy en situaciones competitivas','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Suelo enfadarme mucho cuando estoy bajo presion','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Siempre que puedo trato de desarrollar dos o mas tareas al mismo tiempo','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'Suelo trabajar a contra reloj','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'No tengo paciencia para las demoras','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "INSERT INTO personalidadABPreguntas VALUES (NULL,'A menudo me apresuro sin que haya necesidad','Casi siempre','Muchas veces','Rara vez','Nunca');";
        db.execSQL(query);

        query = "CREATE TABLE personalidadABRespuestas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "respuesta1 INTEGER NOT NULL, " +
                "respuesta2 INTEGER NOT NULL, " +
                "respuesta3 INTEGER NOT NULL, " +
                "respuesta4 INTEGER NOT NULL, " +
                "respuesta5 INTEGER NOT NULL, " +
                "respuesta6 INTEGER NOT NULL, " +
                "respuesta7 INTEGER NOT NULL, " +
                "respuesta8 INTEGER NOT NULL, " +
                "respuesta9 INTEGER NOT NULL, " +
                "respuesta10 INTEGER NOT NULL, " +
                "respuesta11 INTEGER NOT NULL, " +
                "respuesta12 INTEGER NOT NULL, " +
                "respuesta13 INTEGER NOT NULL, " +
                "respuesta14 INTEGER NOT NULL);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String queryTablaPreguntas = "CREATE TABLE preguntas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "imagen TEXT NOT NULL, " +
                "resp1 TEXT NOT NULL, " +
                "resp2 TEXT NOT NULL, " +
                "resp3 TEXT NOT NULL, " +
                "resp4 TEXT NOT NULL, " +
                "resp5 TEXT NOT NULL);";

        String queryTablaRespuestas = "CREATE TABLE respuestas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "respuesta1 INTEGER NOT NULL, " +
                "respuesta2 INTEGER NOT NULL, " +
                "respuesta3 INTEGER NOT NULL, " +
                "respuesta4 INTEGER NOT NULL, " +
                "respuesta5 INTEGER NOT NULL, " +
                "respuesta6 INTEGER NOT NULL, " +
                "respuesta7 INTEGER NOT NULL, " +
                "respuesta8 INTEGER NOT NULL, " +
                "respuesta9 INTEGER NOT NULL);";

        String queryTablaResultados = "CREATE TABLE resultados (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha DATETIME NOT NULL, " +
                "tipo_test TEXT NOT NULL, " +
                "id_respuestas INTEGER, " +
                "FOREIGN KEY(id_respuestas) REFERENCES respuestas(id));";

        String queryTestAB = "CREATE TABLE personalidadABPreguntas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "pregunta TEXT NOT NULL, " +
                "resp1 TEXT NOT NULL, " +
                "resp2 TEXT NOT NULL, " +
                "resp3 TEXT NOT NULL, " +
                "resp4 TEXT NOT NULL);";

        String queryRespuestasAB = "CREATE TABLE personalidadABRespuestas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "respuesta1 INTEGER NOT NULL, " +
                "respuesta2 INTEGER NOT NULL, " +
                "respuesta3 INTEGER NOT NULL, " +
                "respuesta4 INTEGER NOT NULL, " +
                "respuesta5 INTEGER NOT NULL, " +
                "respuesta6 INTEGER NOT NULL, " +
                "respuesta7 INTEGER NOT NULL, " +
                "respuesta8 INTEGER NOT NULL, " +
                "respuesta9 INTEGER NOT NULL, " +
                "respuesta10 INTEGER NOT NULL, " +
                "respuesta11 INTEGER NOT NULL, " +
                "respuesta12 INTEGER NOT NULL, " +
                "respuesta13 INTEGER NOT NULL, " +
                "respuesta14 INTEGER NOT NULL);";

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS preguntas");
        db.execSQL("DROP TABLE IF EXISTS respuestas");
        db.execSQL("DROP TABLE IF EXISTS resultados");
        db.execSQL("DROP TABLE IF EXISTS personalidadABPreguntas");
        db.execSQL("DROP TABLE IF EXISTS personalidadABRespuestas");
        //Se crea la nueva versión de la tabla
        db.execSQL(queryTablaPreguntas);
        db.execSQL(queryTablaRespuestas);
        db.execSQL(queryTablaResultados);
        db.execSQL(queryTestAB);
        db.execSQL(queryRespuestasAB);
    }
}