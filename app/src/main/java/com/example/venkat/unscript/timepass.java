package com.example.venkat.unscript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class timepass extends AppCompatActivity {
    Button bud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepass);
        bud = (Button)findViewById(R.id.bud);
    }

    public void buclk(View view) {
        Toast.makeText(timepass.this,"Working",Toast.LENGTH_LONG).show();

    }
}
