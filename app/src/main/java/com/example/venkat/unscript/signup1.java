package com.example.venkat.unscript;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class signup1 extends AppCompatActivity {

    String fullname;
    String roll;
    String password;
    String email;
    String phn;
    long phnno;
    Button submitB;
    Button sub;
    EditText name,rollno,pass,em,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
      //  submitB=(Button) findViewById(R.id.submitbutton);
        name=(EditText) findViewById(R.id.fullname);
        sub = (Button)findViewById(R.id.submit_button);

//        sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplication(),"Working",Toast.LENGTH_LONG).show();
//            }
//        });
        Toast.makeText(signup1.this,name.getText().toString(),Toast.LENGTH_LONG).show();
        fullname=name.getText().toString();
        rollno=(EditText) findViewById(R.id.rollno);
        roll=rollno.getText().toString();
        pass=(EditText) findViewById(R.id.password);
        password= pass.getText().toString();
        em=(EditText) findViewById(R.id.email);
        email= em.getText().toString();
        phone=(EditText) findViewById(R.id.phoneno);
        phn=phone.getText().toString();

//        Toast.makeText(signup1.this,"Error handelling", LENGTH_LONG).show();
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup1.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }





}
