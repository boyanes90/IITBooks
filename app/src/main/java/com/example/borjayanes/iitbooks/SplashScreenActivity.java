package com.example.borjayanes.iitbooks;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {

        TextView splashText, textSign;
        ImageView hawk;


        // Set the duration of the splash screen
        private static final long SPLASH_SCREEN_DELAY = 3000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Set portrait orientation
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            // Hide title bar
            requestWindowFeature(Window.FEATURE_NO_TITLE);

            setContentView(R.layout.activity_splash_screen);

            splashText = (TextView) findViewById(R.id.textViewSplash);
            textSign = (TextView) findViewById(R.id.textViewSign);
            hawk = (ImageView) findViewById(R.id.imageHawk);

            Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
            splashText.setTypeface(font);
            textSign.setTypeface(font);

            TimerTask task = new TimerTask() {
                @Override
                public void run() {

                    // Start the next activity
                    Intent mainIntent = new Intent().setClass(
                            SplashScreenActivity.this, LoginActivity.class);
                    startActivity(mainIntent);

                    // Close the activity so the user won't able to go back this
                    // activity pressing Back button
                    finish();
                }
            };

            // Simulate a long loading process on application startup.
            Timer timer = new Timer();
            timer.schedule(task, SPLASH_SCREEN_DELAY);
        }

    }