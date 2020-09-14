package com.example.serie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String msg = " ";

        int a = 1;
        int b = 2;



        while (b<=3000) {
            a = a + b;
            b = b + a;
            msg += a +", "+b + ";";
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
