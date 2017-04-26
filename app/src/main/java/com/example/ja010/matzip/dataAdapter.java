package com.example.ja010.matzip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ja010 on 17-04-13.
 */
public class dataAdapter extends BaseAdapter{
    ArrayList<data> nd = new ArrayList<data>();
    Context context;
    static boolean cb = false;


    public dataAdapter( ArrayList<data> nd,Context context){
        this.nd =nd;
        this.context = context;


    }

    @Override
    public int getCount() {
        return nd.size();
    }

    @Override
    public Object getItem(int position) {
        return nd.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = LayoutInflater.from(context);
        if(convertView == null){
            convertView = inf.inflate(R.layout.listview,null);
        }
            data one = nd.get(position);
            TextView tv1 = (TextView) convertView.findViewById(R.id.tl1);
            TextView tv2 = (TextView) convertView.findViewById(R.id.tl2);
            ImageView im = (ImageView)convertView.findViewById(R.id.il1);
            CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.CB);
            tv1.setText(one.getName());
            tv2.setText(""+one.getPhone());
            if(one.getIschecked() ==1){
               im.setImageResource(R.drawable.ch);
            }
            else if(one.getIschecked()==2){
                im.setImageResource(R.drawable.pz);
            }
            else {
                im.setImageResource(R.drawable.ham);
            }
        if(cb){
            checkBox.setVisibility(CheckBox.VISIBLE);
        }
        else{
            checkBox.setVisibility(CheckBox.INVISIBLE);
        }
        one.ct = checkBox.isChecked()?true:false;
        return convertView;
    }

    // 비교
    Comparator<data> nameASC = new Comparator<data>() {
        @Override
        public int compare(data o1, data o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }

    };
    Comparator<data> MENU_ASC = new Comparator<data>() {
        @Override
        public int compare(data o1, data o2) {
            String a =String.valueOf(o1.getIschecked());
            String b = String.valueOf(o2.getIschecked());
            return a.compareToIgnoreCase(b);

        }
    };
    public void setNameASC_SORT(){
        Collections.sort(nd,nameASC);
        this.notifyDataSetChanged();
    }
    public void MENU_ASC_SORT(){
        Collections.sort(nd,MENU_ASC);
        this.notifyDataSetChanged();
    }

}
