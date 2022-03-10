package com.sushantc.skycore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.sushantc.skycore.api.ServiceGenerator;
import com.sushantc.skycore.databinding.ActivityMainBinding;
import com.sushantc.skycore.viewmodel.BusinessViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private BusinessViewModel viewModel;
    private MyListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
         binding.setLifecycleOwner(this);
         binding.radiusValue.setText("100M");
         viewModel = new ViewModelProvider(this).get(BusinessViewModel.class);
         adapter = new MyListAdapter();
         binding.restaurantList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
         binding.restaurantList.setAdapter(adapter);

         binding.radiusSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                 if (b)
                     binding.progressBar.setVisibility(View.VISIBLE);
                 double radius = i;
                 binding.radiusValue.setText(convertValue(radius));
                 convertValue(radius);
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {

             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {
                 double radius = seekBar.getProgress();
                 int input = (int)Math.round(radius);
                 viewModel.getBusinessList(MainActivity.this,"restaurants"
                         ,"London",input,"distance",50)
                         .observe(MainActivity.this,businesses -> {
                             if (businesses!=null && businesses.size()!=0) {
                                 adapter.submitList(businesses);
                                 binding.restaurantList.setVisibility(View.VISIBLE);
                                 binding.progressBar.setVisibility(View.GONE);
                                 binding.noDataFound.setVisibility(View.GONE);
                             }
                             else {
                                 binding.progressBar.setVisibility(View.GONE);
                                 binding.noDataFound.setVisibility(View.VISIBLE);
                                 binding.restaurantList.setVisibility(View.GONE);
                             }
                         });

             }
         });



    }

    private String convertValue(double i) {
        float input = (int)Math.round(i);
        String output = input>=1000? (input/1000)+"KM":i+"M";
        Log.i("Convert",output+" or "+(input/1000));
        return output;
    }
}