package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class second extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        final int hapValue = inIntent.getIntExtra("Num 1", 0) + inIntent.getIntExtra("Num 2", 0);

        Button btn_return;
        btn_return = findViewById(R.id.btn_return);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outInent = new Intent(getApplicationContext(), two_wayActivity.class);
                outInent.putExtra("Hap", hapValue);
                setResult(RESULT_OK, outInent);
                finish();
            }
        });
    }
}
