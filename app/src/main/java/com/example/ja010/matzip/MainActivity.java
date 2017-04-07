package com.example.ja010.matzip;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int GET_CODE = 100;
    ListView listview;
    ArrayList<ArrayList<data>> sss = new ArrayList<>(10);
    ArrayList<data> store = new ArrayList<>();
    ArrayList<String> CONNECT_LIST = new ArrayList<>();

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListview();


    }
    public void onClick(View v){

        Intent DATA_INPUT = new Intent(MainActivity.this,Main2Activity.class);
        DATA_INPUT.putExtra("name",1);
        startActivityForResult(DATA_INPUT,GET_CODE);
    }
    public void setListview(){
        listview =(ListView)findViewById(R.id.listview);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("취소?").setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(),"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                        CONNECT_LIST.remove(position);

                        adapter.notifyDataSetChanged();
                    }
                });
                dig.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"원상태로.",Toast.LENGTH_SHORT).show();
                    }
                });
                dig.show();
                return false;
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent j = new Intent(MainActivity.this,Main3Activity.class);
                if(position ==0){
                    Toast.makeText(getApplicationContext(),"a"+sss.get(0),Toast.LENGTH_SHORT).show();
                    j.putExtra("data",sss.get(0));
                    startActivity(j);
                }
                else if (position == 1){
                    Toast.makeText(getApplicationContext(),"a"+sss.get(1),Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GET_CODE){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                store = data.getParcelableArrayListExtra("array");
                Toast.makeText(getApplicationContext(),"a"+store.toString(),Toast.LENGTH_SHORT).show();
                CONNECT_LIST.add(name);
                sss.add(store);

                adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,CONNECT_LIST);
                listview.setAdapter(adapter);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
