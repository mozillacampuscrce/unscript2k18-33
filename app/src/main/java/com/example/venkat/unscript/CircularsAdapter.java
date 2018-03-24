package com.example.venkat.unscript;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shantanu on 25/3/18.
 */

public class CircularsAdapter extends RecyclerView.Adapter<CircularsAdapter> {
    List<Circulars> circularsList;
    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView= LayoutInflater.from(parent.getContext()).inflate(R.layout.circulars_list_item,parent,false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



}
