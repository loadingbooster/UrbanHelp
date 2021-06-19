package com.www.urban.help.vijay.urbanhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class selleractivity extends AppCompatActivity {

    private ArrayList<String> airconrepairsellernames = new ArrayList<>();
    private ArrayList<String> airconrepairprice = new ArrayList<>();
    private ArrayList<String> airconrepairratings = new ArrayList<>();

    private ArrayList<String> airconinstallsellernames = new ArrayList<>();
    private ArrayList<String> airconinstallprice = new ArrayList<>();
    private ArrayList<String> airconinstallratings = new ArrayList<>();

    private ArrayList<String> airconservicename = new ArrayList<>();
    private ArrayList<String> airconserviceprice = new ArrayList<>();
    private ArrayList<String> airconservicerating = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    String intentmessage;
    DatabaseReference myref = database.getReference();
 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selleractivity);


        Intent intent = getIntent();
        intentmessage = intent.getStringExtra("key");
        Toast.makeText(this, intentmessage, Toast.LENGTH_SHORT).show();
        if(intentmessage.equals("repair")){
            myref.child("aircon").child("install").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ArrayList<String> sellername = new ArrayList<>();
                    Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                    while(items.hasNext()){
                        DataSnapshot item = items.next();
                        String name = item.child("name").getValue().toString();
                        airconinstallsellernames.add(name);
                        String price = item.child("price").getValue().toString();
                        airconinstallprice.add(price);
                        String rating = item.child("rating").getValue().toString();
                        airconinstallratings.add(rating);
                    }
                    airconinstall();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        if(intentmessage.equals("install")){
            Toast.makeText(this, intentmessage, Toast.LENGTH_SHORT).show();
            airconinstall();
        }
        if(intentmessage.equals("service")){
            Toast.makeText(this, intentmessage, Toast.LENGTH_SHORT).show();

        }

    }

    private void airconserice(){


    }
    private void airconserviceadapter(){
        RecyclerView recyclerView = findViewById(R.id.sellerrecyclerview);
        airconserviceadapter airconserviceadapter = new airconserviceadapter(airconservicename,airconserviceprice,airconservicerating,this);
        recyclerView.setAdapter(airconserviceadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void airconrepair(){
        airconrepairrecyclerview();
    }
    private void airconrepairrecyclerview(){
        RecyclerView recyclerView = findViewById(R.id.sellerrecyclerview);
        airconrepairadapter adapter = new airconrepairadapter(airconrepairsellernames,airconrepairprice,airconrepairratings,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void airconinstall(){
        airconinstallrecyclerview();;
    }
    private void airconinstallrecyclerview(){
        RecyclerView recyclerView = findViewById(R.id.sellerrecyclerview);
        airconinstalladapter airconinstalladapter = new airconinstalladapter(airconinstallsellernames,airconinstallprice,airconinstallratings,this);
        recyclerView.setAdapter(airconinstalladapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}