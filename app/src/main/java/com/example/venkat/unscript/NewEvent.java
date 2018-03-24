package com.example.venkat.unscript;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NewEvent extends AppCompatActivity {
    Button btnpk,btnupload;
    EditText event,date,time;
    ProgressDialog mProgressDialog;
    private StorageReference storageRef;
    public static final int PICK_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnpk= (Button) findViewById(R.id.btnpick);
        btnupload= (Button) findViewById(R.id.upload);
        event=(EditText) findViewById(R.id.eventname);
        date=(EditText) findViewById(R.id.mdate);
        mProgressDialog = new ProgressDialog(NewEvent.this);
        time=(EditText) findViewById(R.id.mtime);
        storageRef = FirebaseStorage.getInstance().getReference();
        btnpk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            final String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            String resName = getResources().getResourceEntryName(R.id.imgView);
            // Toast.makeText(getApplicationContext(), picturePath, Toast.LENGTH_LONG).show();
            //event.setText("SET");


            btnupload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (String.valueOf(event.getText()).isEmpty()) {
                        Toast.makeText(NewEvent.this, "Enter Event Name", Toast.LENGTH_SHORT).show();

                    } else if (String.valueOf(date.getText()).isEmpty()) {
                        Toast.makeText(NewEvent.this, "Enter Date", Toast.LENGTH_SHORT).show();

                    } else if (String.valueOf(time.getText()).isEmpty()) {
                        Toast.makeText(NewEvent.this, "Enter Time", Toast.LENGTH_SHORT).show();

                    } else if (picturePath.isEmpty()) {
                        Toast.makeText(NewEvent.this, "Enter Date", Toast.LENGTH_SHORT).show();

                    } else {
                        mProgressDialog.setMessage("Sending Request...");
                        mProgressDialog.show();
                        Uri file = data.getData();//Uri.fromFile(new File(String.valueOf(new File(picturePath))));
                        StorageReference riversRef = storageRef.child("images/" + event.getText() + "/poster.jpg");
                        riversRef.putFile(file)
                                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                        Map<String, String> user = new HashMap<>();
                                        user.put("time", String.valueOf(time.getText()));
                                        user.put("date", String.valueOf(date.getText()));
                                        user.put("success", "0");
                                        db.collection("events").document(String.valueOf(event.getText()))
                                                .set(user)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        //Log.d(TAG, "DocumentSnapshot successfully written!");
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        //Log.w(TAG, "Error writing document", e);
                                                    }
                                                });
                                        mProgressDialog.dismiss();
                                        Toast.makeText(NewEvent.this, "Request Sent", Toast.LENGTH_SHORT).show();
                                        //finish();
                                        downloadUrl = taskSnapshot.getDownloadUrl();
                                        event.setText(String.valueOf(downloadUrl));
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception exception) {
                                        Toast.makeText(NewEvent.this, "Some Problem", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }
            });

        }


    }
}
