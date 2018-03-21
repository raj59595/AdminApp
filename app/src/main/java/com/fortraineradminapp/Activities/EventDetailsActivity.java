package com.fortraineradminapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fortraineradminapp.Models.Event;
import com.fortraineradminapp.R;
import com.fortraineradminapp.Utilities.RetrofitHelper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by specter on 3/14/18.
 */

public class EventDetailsActivity extends AppCompatActivity {

    Event event;

    TextView id;
    TextView name;
    TextView venue;
    TextView amt;
    TextView time;

    public Button btEdit;
    public Button btremove;

    public void editButtonClick(){

        btEdit= (Button)findViewById(R.id.bt_edit);

        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(EventDetailsActivity.this,EventEditActivity.class);
                intent.putExtra("EVENT_DETAILS", new Gson().toJson(event, Event.class));
                startActivity(intent);

            }
        });
    }

    public void removeButtonClick(){

        btremove= (Button)findViewById(R.id.bt_remove);

        btremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<JsonObject> removeEventCall = RetrofitHelper.getRetrofitService().deleteEvent(event.getId());
                removeEventCall.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        if (response.isSuccessful()) {
                            Toast.makeText(EventDetailsActivity.this, "Event Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(EventDetailsActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent intent =  new Intent(EventDetailsActivity.this,EventlistActivity.class);
                intent.putExtra("EVENT_DETAILS", new Gson().toJson(event, Event.class));
                startActivity(intent);

            }
        });
    }
    public static void onEventClicked(Context context, Event event){
        Intent intent = new Intent(context, EventDetailsActivity.class);
        intent.putExtra("EVENT_DETAILS", new Gson().toJson(event, Event.class));
        context.startActivity(intent);
    }

    public void bindViews(){

        id = (TextView)findViewById(R.id.id);
        name =(TextView)findViewById(R.id.name);
        venue = (TextView)findViewById(R.id.venue);
        amt =(TextView)findViewById(R.id.amt);
        time = (TextView)findViewById(R.id.time);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readIntent();
        setContentView(R.layout.activity_event_details);
        bindViews();
        editButtonClick();
        removeButtonClick();

        if(event != null) {
            setEventDetails();
        }else{
            Toast.makeText(this, "failed to get event details", Toast.LENGTH_SHORT).show();

        }
    }


    private void setEventDetails(){
        id.setText(String.valueOf(event.getId()));
        name.setText(event.getName());
        venue.setText(event.getAddressLine1());
        if(event.getIsPaid()){
            amt.setText(event.getPrice());
        }else{
            amt.setText(event.getPrice());
        }
        time.setText(event.getStartDatetime());
    }

    private void readIntent(){

        if (getIntent().getStringExtra("EVENT_DETAILS") == null) {
            Toast.makeText(this, "cant get event", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            event = new Gson().fromJson(getIntent().getStringExtra("EVENT_DETAILS"), Event.class);
        }
    }

}
