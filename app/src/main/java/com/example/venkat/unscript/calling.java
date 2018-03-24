package com.example.venkat.unscript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class calling extends AppCompatActivity {
    Button call;
    RecyclerView recyclerView,recyclerView1,recyclerView2;
    String[] lit,litno,litemail,mkt,mktno,mktemail,tech,techno,techemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        lit= new String[]{"Venky", "Sayli", "Shantanu", "Suyash"};
        litno= new String[]{"9892466035","9820700983","9757022830","8805980300"};
        litemail=new String[]{"venkhatesharunachalam@gmail.com","sayali.patil16@siesgst.ac.in","shantanu.ghar16@siesgst.ac.in","suyash.jaju16@siesgst.ac.in"};

        mkt= new String[]{"Vishal", "Ramesh", "Aaditya"};
        mktno= new String[]{"9892466035","9820700983","9757022830"};
        mktemail=new String[]{"venkhatesharunachalam@gmail.com","sayali.patil16@siesgst.ac.in","shantanu.ghar16@siesgst.ac.in"};

        tech= new String[]{"Ajay", "Sahil", "Kamlesh"};
        techno= new String[]{"9892466035","9820700983","9757022830"};
        techemail=new String[]{"venkhatesharunachalam@gmail.com","sayali.patil16@siesgst.ac.in","shantanu.ghar16@siesgst.ac.in"};
        // call=(Button) findViewById(R.id.btncall);

        recyclerView = findViewById(R.id.list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(calling.this));
        recyclerView.setAdapter(new ListAdapter(lit,litno,litemail,getApplicationContext()));

        recyclerView1 = findViewById(R.id.list_recycler2);
        recyclerView1 = findViewById(R.id.list_recycler2);
        recyclerView1.setLayoutManager(new LinearLayoutManager(calling.this));
        recyclerView1.setAdapter(new ListAdapter(mkt,mktno,mktemail,getApplicationContext()));

        recyclerView2 = findViewById(R.id.list_recycler3);
        recyclerView2 = findViewById(R.id.list_recycler3);
        recyclerView2.setLayoutManager(new LinearLayoutManager(calling.this));
        recyclerView2.setAdapter(new ListAdapter(tech,techno,techemail,getApplicationContext()));
       /* call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8805980300"));
                startActivity(intent);
            }
        });*/


    }
}
