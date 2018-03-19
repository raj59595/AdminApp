package com.fortraineradminapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.fortraineradminapp.Models.Event;
import com.fortraineradminapp.R;
import com.google.gson.Gson;

public class EventEditActivity extends AppCompatActivity {

    Event event;
    /** Android Views **/
    EditText etName;
    EditText etVenue;
    Button btCalendar;
    Button btCalendar1;
    CalendarView calendar;
    CalendarView calendar1;
    EditText stTime;
    EditText edTime;
    EditText etPrice;
    /** Android Views **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        readIntent();

        bindViews();

        setEventValues();


        btCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.setVisibility(View.VISIBLE);
                calendar = (CalendarView) findViewById(R.id.calendar);
                calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                        String date = year + "/" + month+1 + "/" + dayOfMonth;
                        Log.d("EVENT_EDIT", "onSelectedDayChange: yyyy/mm/dd:" + date);
                        stTime.setText(date);
                    }
                });
            }
        });

        btCalendar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar1.setVisibility(View.VISIBLE);
                calendar1 = (CalendarView) findViewById(R.id.calendar1);
                calendar1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                        String date = year + "/" + month + "/" + dayOfMonth;
                        Log.d("EVENT_EDIT", "onSelectedDayChange: yyyy/mm/dd:" + date);
                        edTime.setText(date);

                    }
                });
            }
        });
    }


    private void readIntent() {

        if (getIntent().getStringExtra("EVENT_DETAILS") == null) {
            Toast.makeText(this, "cant get event", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            event = new Gson().fromJson(getIntent().getStringExtra("EVENT_DETAILS"), Event.class);
        }
    }

    private void setEventValues() {

        etName.setText(event.getName());
        etVenue.setText(event.getAddressLine1());
        if(event.getIsPaid()){
            etPrice.setText(event.getPrice());
        }else{
            etPrice.setText(event.getPrice());
        }
        stTime.setText(event.getStartDatetime());
        edTime.setText(event.getEndDatetime());
    }


    /**
 * Binds XML views
 * Call this function after setContentView() in onCreate().
 **/private void bindViews(){
    etName = (EditText) findViewById(R.id.et_name);
    etVenue = (EditText) findViewById(R.id.et_venue);
    btCalendar = (Button) findViewById(R.id.bt_calendar);
    calendar = (CalendarView) findViewById(R.id.calendar);
    btCalendar1 = (Button) findViewById(R.id.bt_calendar1);
    calendar1 = (CalendarView) findViewById(R.id.calendar1);
    stTime = (EditText) findViewById(R.id.et_sttime);
    edTime = (EditText) findViewById(R.id.et_edtime);
    etPrice = (EditText) findViewById(R.id.et_price);
}




}
