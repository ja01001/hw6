package com.example.ja010.matzip;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ja010 on 17-04-06.
 */

public class data implements Parcelable{
    private String name="";
    private int phone = 0;
    private String menu1="";
    private String menu2="";
    private String menu3="";
    private String hp="";
    private String ischecked="";
    public data(String name,int phone,String menu1,String menu2,String menu3,String hp, String ischecked){
        this.name = name;
        this.phone = phone;
        this.menu1 = menu1;
        this.menu2 =menu2;
        this.menu3 = menu3;
        this.hp = hp;
        this.ischecked = ischecked;
    }

    public String getName() {
        return name;
    }

    protected data(Parcel in) {
        name = in.readString();
        phone = in.readInt();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        hp = in.readString();
        ischecked = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(phone);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(hp);
        dest.writeString(ischecked);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<data> CREATOR = new Creator<data>() {
        @Override
        public data createFromParcel(Parcel in) {
            return new data(in);
        }

        @Override
        public data[] newArray(int size) {
            return new data[size];
        }
    };

    @Override
    public String toString() {
        String str = name +":"+phone+":"+menu1+":"+menu2+":"+menu3+":"+hp+":"+ischecked+":";

        return str;
    }
}
