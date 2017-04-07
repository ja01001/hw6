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
    TextView tn,tm1,tm2,tm3,ttel,turl;
    ImageView changeimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tn = (TextView)findViewById(R.id.txtname);
        tm1 = (TextView)findViewById(R.id.etmenu1);
        tm2 = (TextView)findViewById(R.id.etmenu2);
        tm3 = (TextView)findViewById(R.id.etmenu3);
        ttel = (TextView)findViewById(R.id.tvTel);
        turl = (TextView)findViewById(R.id.tvURL);
        changeimg = (ImageView)findViewById(R.id.imgno);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent STORE_DATA = getIntent();
        store_data = STORE_DATA.getParcelableArrayListExtra("data");
        tn.setText(store_data.get(0).getName());
        tm1.setText(store_data.get(0).getMenu1());
        tm2.setText(store_data.get(0).getMenu2());
        tm3.setText(store_data.get(0).getMenu3());
        ttel.setText(store_data.get(0).getPhone());
        turl.setText(store_data.get(0).gethp());
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
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+ttel));
            startActivity(call);
        }
        else if(v.getId() == R.id.imageView3){
            Intent home = new Intent(Intent.ACTION_VIEW,Uri.parse(""+turl));
            startActivity(home);
        }
        else if(v.getId() == R.id.btnback){
            finish();
        }
    }
}
