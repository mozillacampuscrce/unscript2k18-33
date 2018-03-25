package com.example.venkat.unscript;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by venkat on 25/3/18.
 */

public class Admin extends Fragment {
    RecyclerView recyclerView;
    List<String> ls;
    FirebaseFirestore fb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fb = FirebaseFirestore.getInstance();
        ls = new ArrayList<>();
        recyclerView=(RecyclerView)getView().findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fb.collection("events")
            //    .whereEqualTo("success",0)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        HashMap<String,Object> mp = new HashMap<String, Object>();
                        for (DocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            mp.put(document.getId(),document.getData());
                            ls.add(document.getId().toString());
                        }
                        Log.d("Hashmap",mp.toString());
                        Log.d("List",ls.toString());

                    }
                });
        ls.add("EDC");
        ls.add("CODE CELL");
        ls.add("E-CELL");
        ls.add("WOMEN-DEVELOPMENT");
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(ls);
        recyclerView.setAdapter(recyclerViewAdapter);
    }



}


class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<String> language = new ArrayList<>();

    public RecyclerViewAdapter(List<String> language) {
        this.language = language;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutinflate=(View) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_admin, parent, false);
        return new ViewHolder(layoutinflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.songs.setText(language.get(position));
    }

    @Override
    public int getItemCount() {

        return language.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView songs;
        ImageView imgview;
        TextView artist;
        public ViewHolder(View itemView) {
            super(itemView);
            songs=(TextView)itemView.findViewById(R.id.songs);
            artist=(TextView)itemView.findViewById(R.id.artist);
            imgview=(ImageView)itemView.findViewById(R.id.imgview);
        }
    }
}
