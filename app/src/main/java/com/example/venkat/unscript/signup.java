package com.example.venkat.unscript;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        submitB=(Button) findViewById(R.id.submitbutton);
        TextView name=(TextView) findViewById(R.id.fullname);
        fullname=(String) name.getText();
        TextView rollno=(TextView) findViewById(R.id.rollno);
        roll=(String) rollno.getText();
        TextView pass=(TextView) findViewById(R.id.password);
        password=(String) pass.getText();
        TextView em=(TextView) findViewById(R.id.email);
        email=(String) em.getText();
        TextView phone=(TextView) findViewById(R.id.phoneno);
        phn=(String ) phone.getText();
        setContentView(R.layout.activity_login);

       submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hi",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
