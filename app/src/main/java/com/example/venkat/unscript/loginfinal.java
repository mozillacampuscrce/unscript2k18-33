package com.example.venkat.unscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by sayalipatil on 3/25/18.
 */

public class loginfinal extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences shared = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        final String channel = (shared.getString("status", ""));

        Button button=(Button) findViewById(R.id.loginfinal);
        final Intent[] intent = {new Intent()};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(channel.equals("1")){

                    intent[0] = new Intent(loginfinal.this,MainActivity.class);

                }

                else intent[0] = new Intent(loginfinal.this, Circulars.class);
            }
        });
    }


}
