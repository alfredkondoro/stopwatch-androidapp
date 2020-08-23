package com.alfredkondoro.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtSplash, txtSubSplash;
    Button buttonGet;
    Animation atg, btgone, btgtwo;
    ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        txtSplash = findViewById (R.id.txtSplash);
        txtSubSplash = findViewById (R.id.txtSubSplash);
        buttonGet = findViewById (R.id.buttonGet);
        imgSplash = findViewById (R.id.imgSplash);

        atg = AnimationUtils.loadAnimation (this, R.anim.atg);


        imgSplash.startAnimation (atg);
        txtSplash.startAnimation (btgone);
        txtSubSplash.startAnimation (btgone);
        buttonGet.startAnimation (btgtwo);

        buttonGet.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent maintoStop = new Intent (MainActivity.this, StopWatchActivity.class);
                startActivity (maintoStop);
            }
        });
    }
}