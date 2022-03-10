
package com.sushantc.skycore.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Center implements Parcelable
{

    @SerializedName("longitude")
    @Expose
    private Float longitude;
    @SerializedName("latitude")
    @Expose
    private Float latitude;
    public final static Creator<Center> CREATOR = new Creator<Center>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Center createFromParcel(android.os.Parcel in) {
            return new Center(in);
        }

        public Center[] newArray(int size) {
            return (new Center[size]);
        }

    }
    ;

    protected Center(android.os.Parcel in) {
        this.longitude = ((Float) in.readValue((Float.class.getClassLoader())));
        this.latitude = ((Float) in.readValue((Float.class.getClassLoader())));
    }

    public Center() {
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(longitude);
        dest.writeValue(latitude);
    }

    public int describeContents() {
        return  0;
    }

}
