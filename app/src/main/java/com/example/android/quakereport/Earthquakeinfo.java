package com.example.android.quakereport;

/**
 * Created by Hp on 12-03-2017.
 */

public class Earthquakeinfo {
    private String mMagnitude,mMlocation,mDate,mUrl;

    public Earthquakeinfo(String a,String b, String c,String d){
        mDate = c;
        mMlocation = b;
        mMagnitude = a;
        mUrl = d;
    }
    public String getmMagnitude(){
        return mMagnitude;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmMlocation() {
        return mMlocation;
    }
    public String getmUrl(){
        return mUrl;
    }
}
