package com.example.venkat.unscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import static java.security.AccessController.getContext;

/**
 * Created by sayalipatil on 3/25/18.
 */

public class roles extends AppCompatActivity {

    private String flag = "-1";
    public static final String status= "flagkey";
    public static final String MyPREFERENCES = "MyPrefs" ;
    final SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, roles.MODE_PRIVATE);

    RadioButton radioButton2;
    RadioButton radioButton1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radioButton2=(RadioButton) findViewById(R.id.teacher);
        radioButton1=(RadioButton) findViewById(R.id.students);

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((radioButton1.isChecked()) ) {
                    Toast.makeText(getApplicationContext(), "Teacher", Toast.LENGTH_LONG).show();
                    radioButton1.setChecked(true);
                    radioButton2.setChecked(false);
                }
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((radioButton2.isChecked())){
                    Toast.makeText(getApplicationContext(),"Students",Toast.LENGTH_LONG);
                    radioButton2.setChecked(true);
                    radioButton1.setChecked(false);

                }
            }
        });

        Button sub=(Button) findViewById(R.id.poll);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(roles.this,loginfinal.class);
                startActivity(intent);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(status,flag );
                editor.commit();

            }
        });


    }
}
