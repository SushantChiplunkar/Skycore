package com.sushantc.skycore.api;

import com.sushantc.skycore.model.Restaurants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface APIClient {

    @GET("search/")
    Call<Restaurants> getRestaurantsByLocation(@Query("term") String term,@Query("location") String location
            ,@Query("radius") double radius,@Query("sort_by") String sort_by,@Query("limit") int limit);

    @GET("search/")
    Call<Restaurants> getRestaurantsByLatLong(@Query("term") String term,@Query("latitude") double lat
            ,@Query("longitude") double lon,@Query("radius") int radius,@Query("sort_by") String sort_by,@Query("limit") int limit);

}
