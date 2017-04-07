package com.example.ja010.matzip;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    ArrayList<data> store_data = new ArrayList<>();
    TextView tn,tm1,tm2,tm3,ttel,turl,tday;
    ImageView changeimg;
    String ss,sss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("나의 맛집");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tday =(TextView)findViewById(R.id.ssssss);
        tn = (TextView)findViewById(R.id.z);
        tm1 = (TextView)findViewById(R.id.zz);
        tm2 = (TextView)findViewById(R.id.zzz);
        tm3 = (TextView)findViewById(R.id.zzzz);
        ttel = (TextView)findViewById(R.id.zzzzz);
        turl = (TextView)findViewById(R.id.zzzzzz);
        changeimg = (ImageView)findViewById(R.id.im);
        Intent STORE_DATA = getIntent();
        store_data = STORE_DATA.getParcelableArrayListExtra("data");
        ss = String.valueOf(store_data.get(0).getPhone());
        sss = store_data.get(0).gethp();
        tn.setText(""+store_data.get(0).getName());
        tm1.setText(""+store_data.get(0).getMenu1());
        tm2.setText(""+store_data.get(0).getMenu2());
        tm3.setText(""+store_data.get(0).getMenu3());
        ttel.setText("0"+ss);
        turl.setText(""+sss);
        tday.setText(""+store_data.get(0).getday());
        if(store_data.get(0).getIschecked() ==2131427426){
        changeimg.setImageResource(R.drawable.ch);
        }
        else if(store_data.get(0).getIschecked()==2131427427){
            changeimg.setImageResource(R.drawable.ch);
        }
        else {
            changeimg.setImageResource(R.drawable.ch);
        }

    }
    public void onClick(View v){
        if(v.getId() ==R.id.imageView2){
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+ss));
            startActivity(call);
        }
        else if(v.getId() == R.id.imageView3){
            Intent home = new Intent(Intent.ACTION_VIEW,Uri.parse(""+sss));
            startActivity(home);
        }
        else if(v.getId() == R.id.btnback){
            finish();
        }
    }
}
