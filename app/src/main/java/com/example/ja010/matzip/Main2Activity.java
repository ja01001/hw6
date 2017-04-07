package com.example.ja010.matzip;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<data> store = new ArrayList<>();
    EditText n,tel,m1,m2,m3,hp;
    int rb;
    RadioGroup rgb;
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
        rgb = (RadioGroup)findViewById(R.id.rg);
    }
    public void onClick(View v){
        if(v.getId() == R.id.btnAdd){
            String  a = n.getText().toString();
            int  b = Integer.parseInt(tel.getText().toString());
            String  c = m1.getText().toString();
            String  d = m2.getText().toString();
            String  e = m3.getText().toString();
            String  f = hp.getText().toString();
            rb =  rgb.getCheckedRadioButtonId();
            data st = new data(a,b,c,d,e,f,rb);//2131427426~8 =순서 대로 체크
            Toast.makeText(getApplicationContext(),""+st.toString(),Toast.LENGTH_SHORT).show();
            Intent getIn = getIntent();
            int asd = getIn.getIntExtra("data",1);
            if(asd ==1){
                store.add(st);
                String name = st.getName();
                getIn.putExtra("name",name);
                getIn.putParcelableArrayListExtra("array",store);
                setResult(RESULT_OK,getIn);
            }

            finish();
        }
        else if(v.getId() ==R.id.btnCancel){
            this.finish();
            Toast.makeText(getApplicationContext(),"취소되었습니다.",Toast.LENGTH_SHORT).show();
        }

    }


}
