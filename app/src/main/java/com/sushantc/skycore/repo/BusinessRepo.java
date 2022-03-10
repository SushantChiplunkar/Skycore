package com.sushantc.skycore.repo;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sushantc.skycore.api.APIClient;
import com.sushantc.skycore.api.ServiceGenerator;
import com.sushantc.skycore.model.Business;
import com.sushantc.skycore.model.Restaurants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessRepo {
    private static BusinessRepo instance;
    private APIClient apiClient;

    public static BusinessRepo getInstance() {
        if (instance==null)
            instance = new BusinessRepo();
        return instance;
    }

    public BusinessRepo() {
        apiClient = ServiceGenerator.createService(APIClient.class);
    }

    public LiveData<List<Business>> getAllBusiness(Context context, String term, String location, double radius, String sort_by, int limit){
        MutableLiveData<List<Business>> allBusiness = new MutableLiveData<>();
        int value = (int)Math.round(radius);
        apiClient.getRestaurantsByLocation(term,location,value,sort_by,limit).enqueue(new Callback<Restaurants>() {
            @Override
            public void onResponse(Call<Restaurants> call, Response<Restaurants> response) {
                if (response.isSuccessful()){
                    allBusiness.postValue(response.body().getBusinesses());
                }
            }

            @Override
            public void onFailure(Call<Restaurants> call, Throwable t) {
                Toast.makeText(context, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return allBusiness;
    }

    public LiveData<List<Business>> getAllBusinessWithoutLimit(Context context, String term, String location, double radius, String sort_by){
        MutableLiveData<List<Business>> allBusiness = new MutableLiveData<>();
        int value = (int)Math.round(radius);
        apiClient.getRestaurantsByLocationWithoutLimit(term,location,value,sort_by).enqueue(new Callback<Restaurants>() {
            @Override
            public void onResponse(Call<Restaurants> call, Response<Restaurants> response) {
                if (response.isSuccessful()){
                    allBusiness.postValue(response.body().getBusinesses());
                }
            }

            @Override
            public void onFailure(Call<Restaurants> call, Throwable t) {
                Toast.makeText(context, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return allBusiness;
    }
}
