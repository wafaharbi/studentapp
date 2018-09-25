package com.example.wafa.studentapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;

public class StudentInfo extends AppCompatActivity {

    FirebaseDatabase mFirebaseDatabase;
    FirebaseAuth  auth;
    FirebaseAuth.AuthStateListener authStateListener;
    DatabaseReference databaseReference;
    String userID;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        listView = (ListView) findViewById( R.id.listInfoStudent);
        auth =FirebaseAuth.getInstance();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = mFirebaseDatabase.getReference();
        FirebaseUser studentuser = auth.getCurrentUser();
        userID =studentuser.getUid();

        authStateListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               FirebaseUser studentuser = firebaseAuth.getCurrentUser();
               if(studentuser != null){
                   //////////
                }
                else{
                ////////////
               }
            }
        };

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    public  void showData(DataSnapshot dataSnapshot){

        for(DataSnapshot ds: dataSnapshot.getChildren()){

            UserInformation Uinfo =new UserInformation();

            Uinfo.setName(ds.child( userID).getValue(UserInformation.class).getName());
            Uinfo.setEmail(ds.child(userID).getValue(UserInformation.class).getEmail());
            Uinfo.setPassword(ds.child(userID).getValue(UserInformation.class).getPassword());
            Uinfo.setPhone(ds.child(userID).getValue(UserInformation.class).getPhone());

            ArrayList<String>  array = new ArrayList<>();
            array.add(Uinfo.getName());
            array.add(Uinfo.getEmail());
            array.add(Uinfo.getPassword());
            array.add(Uinfo.getPhone());

            ArrayAdapter arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , array);
            listView.setAdapter(arrayAdapter);




        }
    }

    public  void updteclass(View v) {
      Intent i = new Intent(this, StudentUpdateInfo.class);
      startActivity(i);
    }
}
