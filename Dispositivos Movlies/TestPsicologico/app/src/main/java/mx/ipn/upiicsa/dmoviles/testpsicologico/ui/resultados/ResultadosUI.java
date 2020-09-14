package mx.ipn.upiicsa.dmoviles.testpsicologico.ui.resultados;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.upiicsa.dmoviles.testpsicologico.FactorsActivity;
import mx.ipn.upiicsa.dmoviles.testpsicologico.R;
import mx.ipn.upiicsa.dmoviles.testpsicologico.ResultadosActivity;
import mx.ipn.upiicsa.dmoviles.testpsicologico.model.AuxSQLite;

public class ResultadosUI extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_resultados, container, false);
        final ListView listView = root.findViewById(R.id.list_view);
        final ListView listViewAB = root.findViewById(R.id.list_viewAB);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, android.R.id.text1, actualizar());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long i = parent.getItemIdAtPosition(position);
                Intent intent = new Intent(getContext(), ResultadosActivity.class);
                intent.putExtra("tipo_test", "respuestas");
                intent.putExtra("position", position);
                intent.putExtra("preguntasTabla", "preguntas");
                startActivity(intent);
            }
        });

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, android.R.id.text1, actualizar2());
        listViewAB.setAdapter(adapter2);

        listViewAB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long i = parent.getItemIdAtPosition(position);
                Intent intent = new Intent(getContext(), ResultadosActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("tipo_test", "personalidadABRespuestas");
                intent.putExtra("preguntasTabla", "personalidadABPreguntas");
                startActivity(intent);
            }
        });


        return root;
    }

    private List<String> actualizar() {
        List<String> stringListTest = new ArrayList<>();
        AuxSQLite cmd = new AuxSQLite(getContext(), "DBPreguntas", null, 1);
        SQLiteDatabase db = cmd.getReadableDatabase();
        if(db != null) {
            Cursor c = db.rawQuery("SELECT id, tipo_test, fecha FROM resultados WHERE tipo_test= 'Rorscharch'", null);
            if (c.moveToFirst()) {
                do {
                     stringListTest.add(" Test: " +c.getString(1) +" Realizado el: " + c.getString(2));
                } while(c.moveToNext());
            }
            c.close();
            db.close();
        }
        return stringListTest;
    }

    private List<String> actualizar2() {
        List<String> stringListTest = new ArrayList<>();
        AuxSQLite cmd = new AuxSQLite(getContext(), "DBPreguntas", null, 1);
        SQLiteDatabase db = cmd.getReadableDatabase();
        if(db != null) {
            Cursor c = db.rawQuery("SELECT id, tipo_test, fecha FROM resultados WHERE tipo_test= 'PersonalidadAB'", null);
            if (c.moveToFirst()) {
                do {
                    stringListTest.add(" Test: " +c.getString(1) +" Realizado el: " + c.getString(2));
                } while(c.moveToNext());
            }
            c.close();
            db.close();
        }
        return stringListTest;
    }


}
