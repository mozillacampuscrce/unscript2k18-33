package com.example.venkat.unscript;

import android.app.usage.UsageEvents;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * Created by venkat on 24/3/18.
 */

public class Calendar extends Fragment {
    CalendarView mcalen;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference cr = db.collection("calendar");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mcalen = (CalendarView)getView().findViewById(R.id.calendarView);
        return inflater.inflate(R.layout.calendar,
                container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        cr.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                Log.d("Snapshot",documentSnapshots.getDocuments().toString());
                for(DocumentSnapshot dc : documentSnapshots.getDocuments()){
                    Log.d("for loop",dc.toString());
                }
            }
        });
    }

    CalendarView calendar=(CalendarView) getView().findViewById(R.id.calendarView);
    long date;


}
