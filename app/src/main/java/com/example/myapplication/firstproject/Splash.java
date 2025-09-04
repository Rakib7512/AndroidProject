package com.example.myapplication.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private TextView splashTextView;
    private final String message = "প্রাথমিক স্বাস্থ্য সেবায় আপনাকে স্বাগতম";

    private int index = 0;
    private final long delay = 150;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            if (index <= message.length()) {
                splashTextView.setText(message.substring(0, index++));
                handler.postDelayed(this, delay);
            } else {
                // Typing finished → Move to Home screen
                handler.postDelayed(() -> {
                    startActivity(new Intent(Splash.this, Home.class));
                    finish();
                }, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        splashTextView = findViewById(R.id.splashTextView);

        // Start the typing animation
        handler.postDelayed(characterAdder, delay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(characterAdder);
    }
}
