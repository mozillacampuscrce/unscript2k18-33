package com.example.venkat.unscript;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.venkat.unscript.Circulars;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shantanu on 25/3/18.
 */

public class CircularsAdapter extends RecyclerView.Adapter<CircularsAdapter.ViewHolder> {

    List<Circulars> msglst;
    ArrayList<Circulars> cache = new ArrayList<>();
    Context context;

   public CircularsAdapter()
   {

   }

    public CircularsAdapter(List<Circulars> msglst, Context context) {
        this.msglst = msglst;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.circulars_list_item, parent, false);

        return new ViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dis_msg_title.setText("$"+msglst.get(position).getTitle());
        //holder.dis_msg_description.setText(msglst.get(position).getDescription());
        holder.dis_msg_description.setText(msglst.get(position).getDescription());
        holder.dis_msg_time.setText(msglst.get(position).getTime());
        holder.dis_msg_date.setText(msglst.get(position).getDate());
        Log.w("TAgSomething", cache.toString());

    }

    @Override
    public int getItemCount() {
        return msglst.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dis_msg_title, dis_msg_description, dis_msg_time, dis_msg_date;

        public ViewHolder(View itemView) {
            super(itemView);
            dis_msg_description = (TextView) itemView.findViewById(R.id.dis_msg_description);
            dis_msg_time = (TextView) itemView.findViewById(R.id.dis_msg_time);
            dis_msg_date = (TextView) itemView.findViewById(R.id.dis_msg_date);
        }
    }
}
