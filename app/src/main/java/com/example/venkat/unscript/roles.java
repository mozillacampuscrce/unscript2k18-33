package com.example.venkat.unscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by sayalipatil on 3/25/18.
 */

public class roles extends AppCompatActivity {

    private String flag = "-1";
    public static final String status= "flagkey";
    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final RadioButton button1=(RadioButton) findViewById(R.id.teacher);
        final RadioButton button2=(RadioButton) findViewById(R.id.students);
        final SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, roles.MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button1.isChecked())
                {
                    flag="0";
                    button1.setChecked(true);
                    button2.setChecked(false);
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button2.isChecked()){
                    flag="1";
                    button1.setChecked(false);
                    button2.setChecked(true);

                }

            }
        });

        Button sub=(Button) findViewById(R.id.poll);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(status,flag );
                editor.commit();
                setContentView(R.layout.loginfinal);
            }
        });


    }
}
