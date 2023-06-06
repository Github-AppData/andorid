package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class two_wayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_way);

        setTitle("양 방향 액티비티");

        Button btn_Main;
        Button btn_plus = findViewById(R.id.btn_plus);

        btn_Main = findViewById(R.id.btn_main);


        btn_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1);
                EditText num2 = findViewById(R.id.num2);
                
                Intent intent = new Intent(getApplicationContext(), second.class);
                
                // 데이터를 넘겨주는 코드
                intent.putExtra("Num 1", Integer.parseInt(num1.getText().toString()));
                intent.putExtra("Num 2", Integer.parseInt(num2.getText().toString()));

                startActivityForResult(intent, 0); // onActivityResult 메서드랑 짝꿍 (콜백함수)

                num1.setText("");
                num2.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계 : " + hap, Toast.LENGTH_SHORT).show();
        }
    }
}
