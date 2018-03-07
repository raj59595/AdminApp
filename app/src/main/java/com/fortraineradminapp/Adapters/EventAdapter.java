package com.fortraineradminapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortraineradminapp.Models.Event;
import com.fortraineradminapp.R;
import com.fortraineradminapp.ViewHolders.EventViewHolder;

import java.util.List;

/**
 * Created by specter on 2/20/18.
 */

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Event> data;
    Context context;
    LayoutInflater inflater;
    List<Event> recyclerItem;

    public EventAdapter(Context context, List<Event> recyclerItems)
    {
        this.recyclerItem = recyclerItems;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View rootView;
        rootView = inflater.inflate(R.layout.event_item, parent, false);
        viewHolder = new EventViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EventViewHolder eventViewHolder = (EventViewHolder) holder;
        eventViewHolder.bindData(context, recyclerItem.get(position));
    }

    @Override
    public int getItemCount() {
        return recyclerItem.size();
    }

}
