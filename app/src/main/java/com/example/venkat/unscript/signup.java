package com.example.venkat.unscript;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by sayalipatil on 3/25/18.
 */

public class signup extends AppCompatActivity {

    String fullname;
    String roll;
    String password;
    String email;
    String phn;
    long phnno;
    Button submitB;
    EditText name,rollno,pass,em,phone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = new Intent(signup.this,MainActivity.class);
        startActivity(intent);
        submitB=(Button) findViewById(R.id.submitbutton);
        name=(EditText) findViewById(R.id.fullname);
        Toast.makeText(signup.this,name.getText().toString(),Toast.LENGTH_LONG).show();
        fullname=name.getText().toString();
        rollno=(EditText) findViewById(R.id.rollno);
        roll=rollno.getText().toString();
        pass=(EditText) findViewById(R.id.password);
        password= pass.getText().toString();
        em=(EditText) findViewById(R.id.email);
        email= em.getText().toString();
        phone=(EditText) findViewById(R.id.phoneno);
        phn=phone.getText().toString();

        Toast.makeText(signup.this,"Error handelling", LENGTH_LONG).show();
       submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signup.this,"Firebase Not Working",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
