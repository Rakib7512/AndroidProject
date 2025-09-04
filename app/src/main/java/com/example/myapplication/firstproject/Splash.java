package com.example.myapplication.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    private TextView splashTextView;

    private String message="প্রাথমিক স্বাস্থ্য সেবায় আপনাকে স্বাগতম";

    private int index=0;
    private long delay=150;

    private Handler handler=new Handler(Looper.getMainLooper());

    private Runnable characterAddre = new Runnable() {
        @Override
        public void run() {
            splashTextView.setText(message.substring(0, index++));

            if (index < message.length()) {
                // Continue typing animation
                handler.postDelayed(characterAddre, delay);
            } else {
                // After animation ends, move to Home activity
                handler.postDelayed(() -> {
                    startActivity(new Intent(getApplicationContext(), Home.class));
                    finish();
                }, 1000); // Delay 1 second before starting Home activity
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);


        splashTextView=findViewById(R.id.splashTextView);

        handler.postDelayed(characterAddre, delay);

    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        handler.removeCallbacks(characterAddre);
    }
}