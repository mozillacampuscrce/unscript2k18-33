package com.example.venkat.unscript;

/**
 * Created by Suyash on 25-03-2018.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shantanu on 17/2/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> implements View.OnClickListener {
    private String[] datalist;
    private String[] datalist2;
    private String[] datalist3;
    Context context;
    int p=0;
    Button call,email;

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "position = " + getItemId(3), Toast.LENGTH_SHORT).show();
        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+datalist2[1]));
                context.startActivity(intent);
            }
        });
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView item_name,item_price;
        Button call,email;
        public ListViewHolder(View itemView) {
            super(itemView);
            item_name=(TextView)itemView.findViewById(R.id.item_name);
            call = (Button) itemView.findViewById(R.id.bcall);
            email = (Button) itemView.findViewById(R.id.bemail);
        }
    }
    public ListAdapter(final String[] datalist, String[] datalist2, String[] datalist3,Context context)
    {
        this.datalist=datalist;
        this.datalist2=datalist2;
        this.datalist3=datalist3;
        this.context=context;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.calllist,parent,false);
        return new ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ListViewHolder holder, final int position) {
        String name=datalist[position];
        //String name2=datalist2[position];
        holder.item_name.setText(name);
        // holder.item_price.setText(name2);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+datalist2[position]));
                context.startActivity(intent);
            }
        });

        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, datalist3[position]);
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");

                context.startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.length;
    }
}
