package com.example.venkat.unscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sayalipatil on 3/25/18.
 */

public class loginfinal extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences shared = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        final String channel = (shared.getString("status", ""));

        button=(Button) findViewById(R.id.buttonNew);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast(loginfinal.this,"Firebase Retrieval error",Toast.LENGTH_LONG).show();


            }


        });
    }


}
