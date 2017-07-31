package com.example.chethan.videoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create a videoview
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        //det video path
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.introvideo);
        //add media controls
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        //to start the video
        videoView.start();
    }
}
