package com.fortraineradminapp.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fortraineradminapp.Activities.EventDetailsActivity;
import com.fortraineradminapp.Models.Event;
import com.fortraineradminapp.R;


/**
 * Created by specter on 2/22/18.
 */

public class EventViewHolder extends RecyclerView.ViewHolder{

    TextView id;
    TextView name;
    TextView venue;
    TextView amt;
    TextView time;
    LinearLayout llEventHolder;

    public EventViewHolder(View itemView)
    {
        super(itemView);
        bindViews(itemView);

    }
    public void bindViews(View rootView){

        id = (TextView)rootView.findViewById(R.id.id);
        name =(TextView)rootView.findViewById(R.id.name);
        venue = (TextView)rootView.findViewById(R.id.venue);
        amt =(TextView)rootView.findViewById(R.id.amt);
        time = (TextView)rootView.findViewById(R.id.time);
        llEventHolder = (LinearLayout) rootView.findViewById(R.id.ll_event_holder);

    }
    public void bindData(final Context context, final Event event){

        id.setText(String.valueOf(event.getId()));
        name.setText(event.getName());
        venue.setText(event.getAddressLine1());
        if(event.getIsPaid()){
            amt.setText("true");
        }else{
            amt.setText("false");
        }
        time.setText(event.getStartDatetime());
        llEventHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //launchEventDetailsScreen();
                if(context!= null){
                    EventDetailsActivity.onEventClicked(context,event);
                }

            }
        });



    }

    private void launchEventDetailsScreen(Context context, Event event){

    }


}
