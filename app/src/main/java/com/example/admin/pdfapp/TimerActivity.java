package com.example.admin.pdfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TimerActivity extends AppCompatActivity {

    ButtonFragment buttonFragment;
    TimerFragment timerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        buttonFragment = new ButtonFragment();
        timerFragment = new TimerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.buttonPanel, buttonFragment, "button").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.timerPanel, timerFragment, "timer").commit();
    }

}
