package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btn_Move,btn_rating, btn_two_way;
    RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Move = findViewById(R.id.Btn_move);
        btn_rating = findViewById(R.id.Btn_rating);
        btn_two_way = findViewById(R.id.Btn_two_way);

        btn_two_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), two_wayActivity.class);
                startActivity(intent);
            }
        });

        btn_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
                startActivity(intent);
            }
        });


        btn_Move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), moveActivity.class);
                startActivity(intent);
            }
        });


    }
}