package com.fortraineradminapp.Utilities;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Karan on 21-02-2018.
 */

public interface RetrofitService {

    @GET("app-events.json")
    Call<JsonObject> getEventlist();

    @GET("app-events/{id}/get-app-event-details.json")
    Call<JsonObject> getAppEventDetails(@Path("id") int eventId);

    @DELETE("app-events/{id}/delete-app-event.json")
    Call<JsonObject> deleteEvent(@Path("id") int eventId);

    @FormUrlEncoded
    @PUT("app-events/{id}/update-app-event.json")
    Call<JsonObject> updateEventDetails(@Path("id") int eventId, @Field("event_name") String event_name,@Field("event_venue") String event_venue,@Field("event_stdate") String event_stdate,@Field("event_eddate") String event_eddate,@Field("event_price") String event_price);

}
