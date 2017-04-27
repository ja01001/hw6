package com.example.ja010.matzip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main2Activity extends AppCompatActivity {

    EditText n,tel,m1,m2,m3,hp;
    int rb;
    CheckBox cc;
    RadioButton r1,r2,r3;
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
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);
        cc = (CheckBox)findViewById(R.id.CB);
    }
    public void onClick(View v){
        if(v.getId() == R.id.btnAdd){
            String  a = n.getText().toString();
            String bb = tel.getText().toString();
            int b =0;
            if(bb.getBytes().length ==0){tel.requestFocus();}
            else{ b = Integer.parseInt(bb);}
            String  c = m1.getText().toString();
            String  d = m2.getText().toString();
            String  e = m3.getText().toString();
            String  f = hp.getText().toString();
            int cc1 =0;
            if(r1.isChecked() == true){
                rb = 1;
            }
            else if(r2.isChecked()==true){
                rb =2;
            }
            else if(r3.isChecked()==true){
                rb = 3;
            }

            Date dt = new Date();
            SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd");
            String str =form.format(dt);
            data st = new data(a,b,c,d,e,f,rb,str,cc1);//2131427426~8 =순서 대로 체크
           // Toast.makeText(getApplicationContext(),""+st.toString(),Toast.LENGTH_SHORT).show();
            Intent getIn = getIntent();
            int asd = getIn.getIntExtra("data",1);
            if(asd ==1){

                getIn.putExtra("array",st);
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
