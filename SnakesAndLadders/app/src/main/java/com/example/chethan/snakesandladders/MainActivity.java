package com.example.chethan.snakesandladders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] mydices = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six};


    public void rollIt(View view){

        Log.i("button", "It is working");
        Random rand = new Random();
        int abc = rand.nextInt(6);

        Log.i("Random number" ,"The generated Random number is " + abc);

        ImageView dice = (ImageView) findViewById(R.id.dice);

        dice.setImageResource(mydices[abc]);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
