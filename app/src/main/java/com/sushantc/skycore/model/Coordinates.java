
package com.sushantc.skycore.model;

import android.os.Parcelable;


public class Coordinates implements Parcelable
{

    private Float latitude;
    private Float longitude;
    public final static Creator<Coordinates> CREATOR = new Creator<Coordinates>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Coordinates createFromParcel(android.os.Parcel in) {
            return new Coordinates(in);
        }

        public Coordinates[] newArray(int size) {
            return (new Coordinates[size]);
        }

    }
    ;

    protected Coordinates(android.os.Parcel in) {
        this.latitude = ((Float) in.readValue((Float.class.getClassLoader())));
        this.longitude = ((Float) in.readValue((Float.class.getClassLoader())));
    }

    public Coordinates() {
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(latitude);
        dest.writeValue(longitude);
    }

    public int describeContents() {
        return  0;
    }

}
