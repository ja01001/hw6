package com.example.ja010.matzip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    EditText n,tel,m1,m2,m3,hp;
    String rb;
    RadioButton b1,b2,b3;
    ArrayList<data> store = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        n = (EditText)findViewById(R.id.etname);
        tel = (EditText)findViewById(R.id.ettel);
        m1 = (EditText)findViewById(R.id.etmenu1);
        m2 = (EditText)findViewById(R.id.etmenu2);
        m3 = (EditText)findViewById(R.id.etmenu3);
        hp = (EditText)findViewById(R.id.etaddr);
        b1 =(RadioButton) findViewById(R.id.radio1);
        b2 =(RadioButton) findViewById(R.id.radio2);
        b3 =(RadioButton) findViewById(R.id.radio3);
    }
    public void onClick(View v){
        if(v.getId() == R.id.btnAdd){
            String  a = n.getText().toString();
            int  b = Integer.parseInt(tel.getText().toString());
            String  c = m1.getText().toString();
            String  d = m2.getText().toString();
            String  e = m3.getText().toString();
            String  f = hp.getText().toString();
            if (b1.isChecked() == true){
                rb = "a";
            }
            else if (b2.isChecked() ==true){
                rb ="b";
            }
            else{
                rb = "c";
            }
            data st = new data(a,b,c,d,e,f,rb);
            Toast.makeText(getApplicationContext(),""+st,Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() ==R.id.btnCancel){
            this.finish();
            Toast.makeText(getApplicationContext(),"취소되었습니다.",Toast.LENGTH_SHORT).show();
        }
    }
}
