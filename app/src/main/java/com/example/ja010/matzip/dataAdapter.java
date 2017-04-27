package com.example.ja010.matzip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ja010 on 17-04-13.
 */
public class dataAdapter extends BaseAdapter implements Filterable {
    ArrayList<data> nd = new ArrayList<data>();
    Context context;
    ArrayList<data> fil = new ArrayList<>();
    static  boolean cb = false;

    Filter f ;

    public dataAdapter(final ArrayList<data> nd, Context context) {
        this.nd = nd;
        this.context = context;
        this.fil = nd;


    }
    private class lf extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = nd;
                results.count = nd.size();
            } else {
                ArrayList<data> itemList = new ArrayList<data>();
                for (data item : nd) {
                    if (item.getName().toUpperCase().contains(constraint.toString().toUpperCase()))
                        itemList.add(item);
                }
                results.values = itemList;
                results.count = itemList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            fil = (ArrayList<data>) results.values;
            if (results.count >= 0) notifyDataSetChanged();
            else notifyDataSetInvalidated();
        }
    }

    @Override
    public int getCount() {
        return fil.size();
    }

    @Override
    public Object getItem(int position) {
        return fil.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inf.inflate(R.layout.listview, null);
        }
        data one = nd.get(position);
        TextView tv1 = (TextView) convertView.findViewById(R.id.tl1);
        TextView tv2 = (TextView) convertView.findViewById(R.id.tl2);
        ImageView im = (ImageView) convertView.findViewById(R.id.il1);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.CB);

        final data nd = fil.get(position);
        if (one.getIschecked() == 1) {
            im.setImageResource(R.drawable.ch);
        } else if (one.getIschecked() == 2) {
            im.setImageResource(R.drawable.pz);
        } else {
            im.setImageResource(R.drawable.ham);
        }
        if (cb) {
            checkBox.setVisibility(CheckBox.VISIBLE);
        } else {
            checkBox.setVisibility(CheckBox.INVISIBLE);
        }
        one.ct = checkBox.isChecked() ? true : false;
        tv1.setText(fil.get(position).getName());
        tv2.setText("" + fil.get(position).getPhone());
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
            String a = String.valueOf(o1.getIschecked());
            String b = String.valueOf(o2.getIschecked());
            return a.compareToIgnoreCase(b);

        }
    };

    public void setNameASC_SORT() {
        Collections.sort(nd, nameASC);
        this.notifyDataSetChanged();
    }

    public void MENU_ASC_SORT() {
        Collections.sort(nd, MENU_ASC);
        this.notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        if(f==null){f = new lf();}
        return f;
    }

}
