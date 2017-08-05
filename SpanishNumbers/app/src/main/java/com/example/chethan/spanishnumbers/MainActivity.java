package com.example.chethan.spanishnumbers;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public void playMusic(View view){

        int id = view.getId();
       // Log.i("id","the is of buttin is "+id);
        String nameId = view.getResources().getResourceEntryName(id);

        int mymus = getResources().getIdentifier(nameId,"raw","com.example.chethan.spanishnumbers");
        MediaPlayer mediaPlayer = MediaPlayer.create(this,mymus);
        mediaPlayer.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
