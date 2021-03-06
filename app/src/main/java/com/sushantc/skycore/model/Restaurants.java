
package com.sushantc.skycore.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Restaurants implements Parcelable
{

    @SerializedName("businesses")
    @Expose
    private List<Business> businesses = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("region")
    @Expose
    private Region region;
    public final static Creator<Restaurants> CREATOR = new Creator<Restaurants>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Restaurants createFromParcel(android.os.Parcel in) {
            return new Restaurants(in);
        }

        public Restaurants[] newArray(int size) {
            return (new Restaurants[size]);
        }

    }
    ;

    protected Restaurants(android.os.Parcel in) {
        in.readList(this.businesses, (com.sushantc.skycore.model.Business.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.region = ((Region) in.readValue((Region.class.getClassLoader())));
    }

    public Restaurants() {
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(businesses);
        dest.writeValue(total);
        dest.writeValue(region);
    }

    public int describeContents() {
        return  0;
    }

}
