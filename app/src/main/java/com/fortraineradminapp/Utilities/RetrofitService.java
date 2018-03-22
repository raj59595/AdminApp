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
    @PUT("app-events/{event_id}/update-app-event.json")
    Call<JsonObject> updateEventDetails(@Path("event_id") int eventId, @Field("name") String event_name,@Field("venue") String event_venue,@Field("start_datetime") String event_stdate,@Field("end_datetime") String event_eddate,@Field("price") String event_price);

}
