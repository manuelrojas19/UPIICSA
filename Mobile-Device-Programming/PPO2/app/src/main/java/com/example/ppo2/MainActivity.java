package com.example.ppo2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtNum;
    TextView lblRNones, lblRPares;
    ArrayList<Integer> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum = (EditText)findViewById(R.id.txtNum);
        lblRNones = (TextView)findViewById(R.id.lblRNones);
        lblRPares = (TextView)findViewById(R.id.lblRPares);
        lst = new ArrayList<Integer>();
    }

    public void btnAgregar_click(View sender){
        int temp = Integer.parseInt(txtNum.getText().toString());
        lst.add(temp);
        Collections.sort(lst);

        String p="", n="";
        for(int i:lst){
            if (i %2 == 0){
                p += i + "\n";
                lblRPares.setText(p);
            }
            else{
                n += i + "\n";
                lblRNones.setText(n);
            }
        }



    }
}
