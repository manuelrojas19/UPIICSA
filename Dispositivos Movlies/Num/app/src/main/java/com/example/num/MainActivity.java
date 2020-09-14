package com.example.num;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText txtnum, txtLst;
    ArrayList<Integer> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum = (EditText)findViewById(R.id.txtNum);
        txtLst = (EditText) findViewById(R.id.txtLst);
        lst = new ArrayList<Integer>();
    }

    public void btnAgregar_click(View sender){
        int temp = Integer.parseInt(txtnum.getText().toString());
        lst.add(temp);
        Collections.sort(lst);

        String s = "";
        for(int i: lst){
            s += i + ", ";
        }
        txtLst.setText(s);
    }

}
