package com.example.android.quakereport;

/**
 * Created by sandor on 14/08/16.
 */
public class Earthquake {
    protected double mMagnitude;
    protected String mLocation;
    protected long mDate;
    protected String mUrl;

    public Earthquake(double magnitude, String location, long date, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
