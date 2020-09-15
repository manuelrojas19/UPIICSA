package com.example.jbox;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_click(View sender) {
        if (mp != null)
            mp.release();
        switch (sender.getId()){
            case R.id.btn1:
                mp = MediaPlayer.create(this, R.raw.son1);
                mp.start();
                break;
            case R.id.btn2:
                mp = MediaPlayer.create(this, R.raw.son2);
                mp.start();
                break;
            case R.id.btn3:
                mp = MediaPlayer.create(this, R.raw.son3);
                mp.start();
                break;
            case R.id.btn4:
                mp = MediaPlayer.create(this, R.raw.son4);
                mp.start();
                break;
            case R.id.btn5:
                mp = MediaPlayer.create(this, R.raw.son5);
                mp.start();
                break;
            case R.id.btn6:
                mp = MediaPlayer.create(this, R.raw.son6);
                mp.start();
                break;
            case R.id.btn7:
                mp = MediaPlayer.create(this, R.raw.son7);
                mp.start();
                break;
            case R.id.btn8:
                mp = MediaPlayer.create(this, R.raw.son8);
                mp.start();
                break;
            case R.id.btn9:
                mp = MediaPlayer.create(this, R.raw.son9);
                mp.start();
                break;
        }
    }
}
