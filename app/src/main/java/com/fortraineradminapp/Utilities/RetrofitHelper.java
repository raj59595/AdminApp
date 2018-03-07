package com.fortraineradminapp.Utilities;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Karan on 22-02-2018.
 */

public class RetrofitHelper {
    static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.82:3000/api/mobile/manager/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;
        //   RetrofitService service = retrofit.create(RetrofitService.class);
    }
    public static RetrofitService getRetrofitService(){
        return getClient().create(RetrofitService.class);
    }
}
