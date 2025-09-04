package com.example.myapplication.firstproject;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class Home extends AppCompatActivity {

    private MaterialButton btnFirst, btnSecond, btnThird, btnFourth, btnFifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        btnThird = findViewById(R.id.btnThird);
        btnFourth = findViewById(R.id.btnFourth);
        btnFifth = findViewById(R.id.btnFifth);

        btnFirst.setOnClickListener(v ->
                Toast.makeText(this, "স্বাস্থ্য সেবা বোতাম চাপা হয়েছে", Toast.LENGTH_SHORT).show()
        );

        btnSecond.setOnClickListener(v ->
                Toast.makeText(this, "ডাক্তার পরামর্শ বোতাম চাপা হয়েছে", Toast.LENGTH_SHORT).show()
        );

        btnThird.setOnClickListener(v ->
                Toast.makeText(this, "ওষুধের তথ্য বোতাম চাপা হয়েছে", Toast.LENGTH_SHORT).show()
        );

        btnFourth.setOnClickListener(v ->
                Toast.makeText(this, "জরুরি নম্বর বোতাম চাপা হয়েছে", Toast.LENGTH_SHORT).show()
        );

        btnFifth.setOnClickListener(v ->
                Toast.makeText(this, "হাসপাতালের তালিকা বোতাম চাপা হয়েছে", Toast.LENGTH_SHORT).show()
        );
    }
}
