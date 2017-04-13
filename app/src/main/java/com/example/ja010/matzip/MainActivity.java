package com.example.ja010.matzip;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int GET_CODE = 100;
    ListView listview;
    ArrayList<data> sss = new ArrayList<>();
    ArrayList<String> CONNECT_LIST = new ArrayList<String>();
  //  ArrayAdapter adapter;
    dataAdapter ad;
    Button bb,bbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bb = (Button)findViewById(R.id.b4);
        bbs = (Button)findViewById(R.id.b5);
        setListview();


    }
    public void onClick(View v){
        if(v.getId()==R.id.b1) {
            Intent DATA_INPUT = new Intent(MainActivity.this, Main2Activity.class);
            DATA_INPUT.putExtra("name", 1);
            startActivityForResult(DATA_INPUT, GET_CODE);
        }
        else if (v.getId() == R.id.b2){
            ad.setNameASC_SORT();
        }
        else if (v.getId() == R.id.b3){
            ad.MENU_ASC_SORT();
        }
        else if (v.getId() == R.id.b4){
            bb.setVisibility(v.GONE);
            bbs.setVisibility(v.VISIBLE);

        }
    }
    public void setListview(){
        listview =(ListView)findViewById(R.id.listview);
       // adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,CONNECT_LIST);
        ad = new dataAdapter(sss,this);
        listview.setAdapter(ad);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("삭제하시겠습니까?").setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                        CONNECT_LIST.remove(position);
                        sss.remove(position);
                        ad.notifyDataSetChanged();
                    }
                });
                dig.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"원상태로.",Toast.LENGTH_SHORT).show();
                    }
                });
                dig.show();
                return true;
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent j = new Intent(MainActivity.this,Main3Activity.class);
                data r =sss.get(position);
                j.putExtra("r",r);
                startActivity(j);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GET_CODE){
            if(resultCode == RESULT_OK){

                data store = data.getParcelableExtra("array");//정의된 data ("array");
                CONNECT_LIST.add(store.getName());
                sss.add(store);
                ad.notifyDataSetChanged();

            }

        }
    }
}
