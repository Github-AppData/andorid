package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class activity_9_3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_9_3);

        Button btnRead, btnBack;
        final EditText edtRaw;
        btnRead = findViewById(R.id.btnRead);
        btnBack = findViewById(R.id.btn_Back);

        edtRaw = (EditText) findViewById(R.id.edtRaw);

        // MainActivity로 이동
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.asd);
                    byte [] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    edtRaw.setText(new String(txt));
                    inputStream.close();
                }
                catch (IOException e){

                }
            }
        });




    }
}
