package com.example.chethan.mypatatap;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void playMusic(View view) {

        int id = view.getId();
        Log.i("id", "id of the button is" + id);

        String nameID;
        nameID = view.getResources().getResourceEntryName(id);

        Log.i("Identifier", "button name : " + nameID);

        int myMus = getResources().getIdentifier(nameID, "raw", "com.example.chethan.mypatatap");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, myMus);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
