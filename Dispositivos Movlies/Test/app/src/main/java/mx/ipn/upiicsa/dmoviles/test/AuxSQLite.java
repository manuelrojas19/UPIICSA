package mx.ipn.upiicsa.dmoviles.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class AuxSQLite extends SQLiteOpenHelper {


    public AuxSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE preguntas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "pregunta TEXT NOT NULL, " +
                "resp1 TEXT NOT NULL, " +
                "correcta1 INTEGER NOT NULL, " +
                "resp2 TEXT NOT NULL, " +
                "correcta2 INTEGER NOT NULL, " +
                "resp3 TEXT NOT NULL, " +
                "correcta3 INTEGER NOT NULL, " +
                "resp4 TEXT NOT NULL, " +
                "correcta4 INTEGER NOT NULL);";
        db.execSQL(query);

        query = "INSERT INTO preguntas VALUES (NULL,'Software que se encarga de comunicar a los programas que se ejecutan en el sistema con el hardware de la computadora de forma segura.','Aplicaciones','incorrect','Sistema operativo','incorrect','Núcleo / Kernel','correct','MS – DOS','incorrect');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Manera en que una aplicación solicita un servicio al sistema operativo.','System call','correct','Solicitud al sistema','incorrect','Comando','incorrect','Instrucción','correct');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Llamado intérprete de comandos:','Núcleo','incorrect','Procesador','correct','Cmd','incorrect','Shell','incorrect');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Parte del sistema operativo encargada de administrar el uso de memoria:','Bios','correct','Sistema de archivos','incorrect','MS-DOS','incorrect','Explorador de archivos','incorrect');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Son aquellos que no forman parte del kernel, pero se encuentran trabajando estrechamente con él para facilitar el acceso y uso de la información:','Programas utilitarios','incorrect','Sistema de archivos','correct','Explorador de archivos','incorrect','Bios','incorrect');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Son sistemas constituidos por módulos grandes interactuando entre sí:','Sistema autónomo','incorrect','Sistema Monolítico','incorrect','Sistema operativo','incorrect','Sistema de archivos','correct');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Se encuentra definido por módulos operativos:','Sistema virtuales','incorrect','Sistema operativo','correct','Sistema no estructurado','incorrect','Sistema estructurado','incorrect');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Software que simula a otro sistema y puede ejecutar procesos como si se tratara de un sistema independiente:','Sistema operativo','incorrect','Sistema operativo virtual','correct','Virtual Box','incorrect','Sistema estructurado','incorrect');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'Esquema de comunicación industrial ampliamente difundido para redes de integración de equipos de control:','Esquema maestro','incorrect','Esquema maestro/esclavo','correct','Esquema esclavo','incorrect','Esquema de integración','incorrect');";
        db.execSQL(query);
        query = "INSERT INTO preguntas VALUES (NULL,'En este sistema los procesos se dividen en dos partes, principalmente consiste en centralizar ciertos procesos en el servidor:','Sistema de intercomunicación','incorrect','Sistema cliente servidor','correct','Sistema binario','incorrect','Sistemas virtuales','incorrect');";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
