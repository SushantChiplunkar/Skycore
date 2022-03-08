
package com.sushantc.skycore.model;

import android.os.Parcelable;

import java.util.List;


public class Business implements Parcelable
{

    private String id;
    private String alias;
    private String name;
    private String imageUrl;
    private Boolean isClosed;
    private String url;
    private Integer reviewCount;
    private List<Category> categories = null;
    private Float rating;
    private Coordinates coordinates;
    private List<Object> transactions = null;
    private String price;
    private Location location;
    private String phone;
    private String displayPhone;
    private Float distance;
    public final static Creator<Business> CREATOR = new Creator<Business>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Business createFromParcel(android.os.Parcel in) {
            return new Business(in);
        }

        public Business[] newArray(int size) {
            return (new Business[size]);
        }

    }
    ;

    protected Business(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.alias = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.isClosed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.reviewCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.categories, (Category.class.getClassLoader()));
        this.rating = ((Float) in.readValue((Float.class.getClassLoader())));
        this.coordinates = ((Coordinates) in.readValue((Coordinates.class.getClassLoader())));
        in.readList(this.transactions, (Object.class.getClassLoader()));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.displayPhone = ((String) in.readValue((String.class.getClassLoader())));
        this.distance = ((Float) in.readValue((Float.class.getClassLoader())));
    }

    public Business() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Object> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Object> transactions) {
        this.transactions = transactions;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(alias);
        dest.writeValue(name);
        dest.writeValue(imageUrl);
        dest.writeValue(isClosed);
        dest.writeValue(url);
        dest.writeValue(reviewCount);
        dest.writeList(categories);
        dest.writeValue(rating);
        dest.writeValue(coordinates);
        dest.writeList(transactions);
        dest.writeValue(price);
        dest.writeValue(location);
        dest.writeValue(phone);
        dest.writeValue(displayPhone);
        dest.writeValue(distance);
    }

    public int describeContents() {
        return  0;
    }

}
