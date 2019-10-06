package com.nursinghomecarebd.www.nursinghomecare.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.nursinghomecarebd.www.nursinghomecare.R;

public class WelcomeScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        progressBar = findViewById(R.id.progressId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                doWork();
                stratApp();
            }


        });

        thread.start();
    }

    public void doWork() {

        for (progress = 20; progress <= 100; progress = progress + 20) {


            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    public void stratApp() {


        Intent i = new Intent(WelcomeScreen.this, LoginActivity.class);

        startActivity(i);

        finish();
    }


}


