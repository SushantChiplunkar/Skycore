
package com.sushantc.skycore.model;

import android.os.Parcelable;


public class Region implements Parcelable
{

    private Center center;
    public final static Creator<Region> CREATOR = new Creator<Region>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Region createFromParcel(android.os.Parcel in) {
            return new Region(in);
        }

        public Region[] newArray(int size) {
            return (new Region[size]);
        }

    }
    ;

    protected Region(android.os.Parcel in) {
        this.center = ((Center) in.readValue((Center.class.getClassLoader())));
    }

    public Region() {
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(center);
    }

    public int describeContents() {
        return  0;
    }

}
