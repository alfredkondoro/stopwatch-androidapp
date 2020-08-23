package com.alfredkondoro.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    ImageView icAnchor;
    Animation roundingAlone;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_stop_watch);
        btnStart = findViewById (R.id.buttonStart);
        btnStop = findViewById (R.id.buttonStop);
        icAnchor = findViewById (R.id.imgClockArm);
        timer = findViewById (R.id.timer);

        btnStop.setAlpha (0);
        roundingAlone = AnimationUtils.loadAnimation (this, R.anim.roundingalone);

        btnStart.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                icAnchor.startAnimation (roundingAlone);
                btnStop.animate ().alpha(1).translationY (-80).setDuration (300).start ();
                btnStart.animate ().alpha (0).setDuration (300).start ();

                timer.setBase(SystemClock.elapsedRealtime ());
                timer.start();
            }
        });


    }
}