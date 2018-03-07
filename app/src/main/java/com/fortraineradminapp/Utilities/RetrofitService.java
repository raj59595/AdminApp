package com.fortraineradminapp.Utilities;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Karan on 21-02-2018.
 */

public interface RetrofitService {

    @GET("app-events.json")
    Call<JsonObject> getEventlist();


}
