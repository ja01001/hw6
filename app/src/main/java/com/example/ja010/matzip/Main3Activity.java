package com.example.ja010.matzip;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


    }
    public void onClick(View v){
        if(v.getId() ==R.id.imageView2){
            String a = "12341234";
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+a));
            startActivity(call);
        }
        else if(v.getId() == R.id.imageView3){
            Intent home = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.naver.com"));
            startActivity(home);
        }
    }
}
