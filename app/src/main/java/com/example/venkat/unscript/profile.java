package com.example.venkat.unscript;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by venkat on 24/3/18.
 */

public class profile extends Fragment{
    String roll = "116a1091";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_rssitem_detail, container, false);
//    }
}
