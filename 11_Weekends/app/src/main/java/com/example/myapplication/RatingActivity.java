package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {


    Button btn_up, btn_down, btn_main;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        final RatingBar ratingBar1, ratingBar2, ratingBar3;

        btn_down = findViewById(R.id.btn_down);
        btn_up = findViewById(R.id.btn_up);
        btn_main = findViewById(R.id.btn_Main);
        ratingBar1 = findViewById(R.id.rating1);
        ratingBar2 = findViewById(R.id.rating2);
        ratingBar3 = findViewById(R.id.rating3);


        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar1.setRating(ratingBar1.getRating() - ratingBar1.getStepSize());
                ratingBar2.setRating(ratingBar2.getRating() - ratingBar2.getStepSize());
                ratingBar3.setRating(ratingBar3.getRating() - ratingBar3.getStepSize());
            }
        });

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar1.setRating(ratingBar1.getRating() + ratingBar1.getStepSize());
                ratingBar2.setRating(ratingBar2.getRating() + ratingBar2.getStepSize());
                ratingBar3.setRating(ratingBar3.getRating() + ratingBar3.getStepSize());
            }
        });

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
