package com.sushantc.skycore.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sushantc.skycore.model.Business;
import com.sushantc.skycore.repo.BusinessRepo;

import java.util.List;

public class BusinessViewModel extends AndroidViewModel {
    private BusinessRepo repo;

    public BusinessViewModel(@NonNull Application application) {
        super(application);
        this.repo = BusinessRepo.getInstance();
    }

    public LiveData<List<Business>> getBusinessList(Context context,String term,String location,double radius,String sort_by,int limit){
        return repo.getAllBusiness(context,term,location,radius,sort_by,limit);
    }

    public LiveData<List<Business>> getBusinessListWithoutLimit(Context context,String term,String location,double radius,String sort_by){
        return repo.getAllBusinessWithoutLimit(context,term,location,radius,sort_by);
    }
}
