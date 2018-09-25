package com.example.wafa.studentapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentUpdateInfo extends AppCompatActivity {



     FirebaseAuth auth;
     FirebaseUser studentuser;
    DatabaseReference ref;
    EditText studentName, studentEmail, studentPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update_info);

        studentName = (EditText) findViewById(R.id.updateName);
        studentEmail = (EditText) findViewById(R.id.updateEmail);
        studentPhone = (EditText) findViewById(R.id.updatePhone);




       /**
        String userID;
        FirebaseUser studentuser = auth.getCurrentUser();
        userID =studentuser.getUid();

       String Users = getIntent().getExtras().get(userID).toString();

        ref = FirebaseDatabase.getInstance().getReference().child(userID);
        studentName.setText(getIntent().getStringExtra("name"));
        studentEmail.setText(getIntent().getStringExtra("email"));
        studentPhone.setText(getIntent().getStringExtra("phone"));
        **/


    }

    public  void update(View v){

    }

    public  void delete(View v){

    }
}
