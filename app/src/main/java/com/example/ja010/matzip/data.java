package com.example.ja010.matzip;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ja010 on 17-04-06.
 */

public class data implements Parcelable {
    private String name="";
    private int phone = 0;
    private String menu1="";
    private String menu2="";
    private String menu3="";
    private String hp="";
    private int ischecked=0;
    private String day = "";
    public data(String name,int phone,String menu1,String menu2,String menu3,String hp, int ischecked,String day){
        this.name = name;
        this.phone = phone;
        this.menu1 = menu1;
        this.menu2 =menu2;
        this.menu3 = menu3;
        this.hp = hp;
        this.ischecked = ischecked;
        this.day = day;
    }

    public String getName() {return name;}
    public int getPhone(){return phone;}
    public String getMenu1() {return menu1;    }
    public String getMenu2() {return menu2;    }
    public String getMenu3() {        return menu3;    }
    public String gethp() {        return hp;    }
    public int getIschecked(){return ischecked;}
    public String getday(){return day;}

    protected data(Parcel in) {
        name = in.readString();
        phone = in.readInt();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        hp = in.readString();
        ischecked = in.readInt();
        day = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(phone);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(hp);
        dest.writeInt(ischecked);
        dest.writeString(day);
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

}
