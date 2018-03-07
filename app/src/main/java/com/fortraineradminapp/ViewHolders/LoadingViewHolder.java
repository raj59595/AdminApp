package com.fortraineradminapp.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.fortraineradminapp.R;
import com.fortraineradminapp.Utilities.CommonRecyclerItem;


/**
 * Created by Karan on 23-02-2018.
 */

public class LoadingViewHolder extends RecyclerView.ViewHolder{
    LinearLayout llProgressHolder;
    ProgressBar progressBar;

    public LoadingViewHolder(View parentView){
        super(parentView);
        llProgressHolder = (LinearLayout)parentView.findViewById(R.id.ll_iw_progress_holder);
        progressBar = (ProgressBar)parentView.findViewById(R.id.progressBar);
    }

    public void bindCRIItem(Context context, CommonRecyclerItem commonRecyclerItem){
        progressBar.setVisibility(View.VISIBLE);
    }
}
//hi