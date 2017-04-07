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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int GET_CODE = 100;
    ListView listview;
    ArrayList<ArrayList<data>> sss = new ArrayList<>(10);
    ArrayList<data> store = new ArrayList<>();
    ArrayList<String> CONNECT_LIST = new ArrayList<>();
    int count;
    ArrayAdapter<String> adapter;
    TextView ti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListview();
        ti = (TextView)findViewById(R.id.tv);

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
                        count= count-1;
                        counta(count);
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
                    j.putExtra("data",sss.get(0));
                    startActivity(j);
                }
                else if (position == 1){
                    j.putExtra("data",sss.get(1));
                    startActivity(j);
                }
                else if (position == 2){j.putExtra("data",sss.get(2));
                    startActivity(j); }
                else if (position == 3){
                    j.putExtra("data",sss.get(3));
                    startActivity(j);
                }
                else if (position == 4){
                    j.putExtra("data",sss.get(4));
                    startActivity(j);
                }
                else if (position == 5){
                    j.putExtra("data",sss.get(5));
                    startActivity(j);
                }
                else if (position == 6){
                    j.putExtra("data",sss.get(6));
                    startActivity(j);
                }
                else if (position == 7){
                    j.putExtra("data",sss.get(7));
                    startActivity(j);
                }
                else if (position == 8){
                    j.putExtra("data",sss.get(8));
                    startActivity(j);
                }
                else if (position == 9){
                    j.putExtra("data",sss.get(9));
                    startActivity(j);
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
                CONNECT_LIST.add(name);
                sss.add(store);
                count += 1;
                adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,CONNECT_LIST);
                listview.setAdapter(adapter);
                counta(count);

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void counta(int count){
        if(count != 0){
            ti.setText("맛집 리스트("+count+"개)");
        }
        else{ti.setText("맛집 리스트("+count+"개)");}

    }
}
