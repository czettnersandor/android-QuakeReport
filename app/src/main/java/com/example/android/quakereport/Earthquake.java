package com.example.android.quakereport;

/**
 * Created by sandor on 14/08/16.
 */
public class Earthquake {
    protected double mMagnitude;
    protected String mCity;
    protected String mDate;

    public Earthquake(double magnitude, String city, String date) {
        mMagnitude = magnitude;
        mCity = city;
        mDate = date;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getCity() {
        return mCity;
    }

    public String getDate() {
        return mDate;
    }
}
