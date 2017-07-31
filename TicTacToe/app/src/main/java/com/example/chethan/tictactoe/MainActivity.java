package com.example.chethan.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myActivePLayer = 0;
    //0 for x and 1 for 0

    int myplayer[] ={2,2,2,2,2,2,2,2,2};
     // to determin the state of the player and to not allow the player again

    public void imageTapped(View view) {

        ImageView mytapped = (ImageView) view;

        //Log.i("tag : " ,"The image tapped is " + mytapped.getTag().toString());

        int pos = Integer.parseInt(mytapped.getTag().toString());

        if(myplayer[pos]==2) {
            myplayer[pos] = myActivePLayer;

            if (myActivePLayer == 0) {
                mytapped.setImageResource(R.drawable.cross);
                mytapped.animate().rotation(360).setDuration(1500);
                myActivePLayer = 1;
            } else {
                mytapped.setImageResource(R.drawable.circle);

                myActivePLayer = 0;

            }
        }
            else{
                //Log.i("not again"," This place is filled already");
                Toast.makeText(getApplicationContext(), "This Position is already played",
                        Toast.LENGTH_LONG).show();

            }

    }

    public void playAgain(View view){

        //Change activeplayer = 0
         myActivePLayer = 0;
        // change all the game states to default
        for(int i=0;i<myplayer.length;i++)
        {
            myplayer[i]= 2;
        }
        // reset all the images to ic_launcher

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.lineone);// To highlight a particular linear layout
        for(int i =0; i<linearLayout.getChildCount();i++)// To select all the components in a linear layout
        {
            ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
            // To convert the linear layout into a particular component view and to set view
        }

        LinearLayout linearLayoutone = (LinearLayout)findViewById(R.id.linetwo);
        for(int i =0; i<linearLayoutone.getChildCount();i++)
        {
            ((ImageView)linearLayoutone.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);

        }

        LinearLayout linearLayouttwo = (LinearLayout)findViewById(R.id.linethree);
        for(int i =0; i<linearLayouttwo.getChildCount();i++)
        {
            ((ImageView)linearLayouttwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
