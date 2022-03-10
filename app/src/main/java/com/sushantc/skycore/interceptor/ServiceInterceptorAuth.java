package com.sushantc.skycore.interceptor;

import androidx.core.os.BuildCompat;
import androidx.viewbinding.BuildConfig;

import com.sushantc.skycore.Constant;

import java.io.IOException;
import java.util.TimeZone;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceInterceptorAuth implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        request = request.newBuilder()
                .header("Authorization", "Bearer "+ Constant.API_KEY)
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .header("X-cosmicVisionApp-timezone-id", TimeZone.getDefault().getID())
                .method(request.method(), request.body())
                .build();

        return chain.proceed(request);
    }
}
