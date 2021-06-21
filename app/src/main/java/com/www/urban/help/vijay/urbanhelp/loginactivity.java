package com.www.urban.help.vijay.urbanhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginactivity extends AppCompatActivity {

    Button loginsignup;
    EditText phonenumber;
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        getSupportActionBar().hide(); //hide the title bar

        loginsignup = findViewById(R.id.loginsignup);
        phonenumber = findViewById(R.id.phonenumberfield);
        loginsignup.setVisibility(View.INVISIBLE);
        DatabaseReference myref = database.getReference();

        boolean foreground = ActivityCompat.checkSelfPermission(loginactivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        if (foreground) {
            Toast.makeText(loginactivity.this, "GRANTED", Toast.LENGTH_SHORT).show();


        } else {
            ActivityCompat.requestPermissions(loginactivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }

        phonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(phonenumber.getText().toString().length() ==10){
                    loginsignup.setVisibility(View.VISIBLE);
                }else{
                    loginsignup.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loginsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myref.child("customers").child(phonenumber.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.getValue() != null){
                            Intent intent = new Intent(getApplicationContext(),otpactivity.class);
                            intent.putExtra("intention","login");
                            intent.putExtra("phone",phonenumber.getText().toString());
                            startActivity(intent);

                        }
                        else{
                            Intent intent = new Intent(getApplicationContext(),otpactivity.class);
                            intent.putExtra("intention","signup");
                            intent.putExtra("phone",phonenumber.getText().toString());
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


    }
}