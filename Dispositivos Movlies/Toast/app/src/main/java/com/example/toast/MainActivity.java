package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 1, b =5, c = 6;
        int x1 = (-b + (int)Math.sqrt(b*b - 4*a*c))/2*a;
        int x2 = (-b - (int)Math.sqrt(b*b - 4*a*c))/2*a;
        String msg;
        msg = "x1= " +x1 + "; x2= " +x2 +";";

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
