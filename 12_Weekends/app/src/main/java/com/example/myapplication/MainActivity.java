package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트 뷰 테스트");


        final String [] mid = {"리그오브레전드", "발로란트", "오버워치", "배틀그라운드", "오버쿡드", "점프킹", "폴 가이즈", "히오스", "서든", "스타크래프트"};


        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = findViewById(R.id.listview1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        final EditText edtItem = findViewById(R.id.edit1);
        Button btn_plus = findViewById(R.id.plus_list);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
                edtItem.setText("");
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View arg1, int arg2, long arg3) {
                /*showWarning();*/
                midList.remove(arg2);
                adapter.notifyDataSetChanged();

                return false;
            }
        });


        /*// 리스트 뷰에 라디오 버튼 추가
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mid);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setAdapter(adapter);*/

        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), mid[arg2], Toast.LENGTH_SHORT).show();
            }
        });*/

    }

   /* public void showWarning() {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this)

                .setTitle("삭제 경고")
                .setMessage("이 아이템을 진짜 삭제 하시겠습니까 ??")
                .setPositiveButton("삭제해라", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        i = 1; // true !
                    }
                })
                .setNegativeButton("노 !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        i = 0;
                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();

    }*/
}