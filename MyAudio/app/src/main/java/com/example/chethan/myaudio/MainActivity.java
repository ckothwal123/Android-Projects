package com.example.chethan.myaudio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public void playtapped(View view){
        mediaPlayer.start();
    }

    public void pausetapped(View view){
        mediaPlayer.pause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.myaudio);

        //calling the audio service
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxvol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //setting values to the seekbar
        SeekBar volrocker = (SeekBar)findViewById(R.id.seekBar);
        volrocker.setMax(maxvol);
        volrocker.setProgress(curvol);

        //Set on change listener
        volrocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setting a player timeline

        final SeekBar timeline = (SeekBar)findViewById(R.id.Timeline);
        timeline.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeline.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1000);

        timeline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}
