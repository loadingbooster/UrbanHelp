package com.www.urban.help.vijay.urbanhelp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class selleractivity extends AppCompatActivity {

    private ArrayList<String> sellernames = new ArrayList<>();
    private ArrayList<String> sellerprice = new ArrayList<>();
    private ArrayList<String> sellerrating = new ArrayList<>();
    private ArrayList<String> sellerphone = new ArrayList<>();


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    String intentmessage;
    DatabaseReference myref = database.getReference();
    ProgressBar loadbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selleractivity);

        sellernames.clear();
        sellerprice.clear();
        sellerrating.clear();
        sellerphone.clear();

        loadbar = findViewById(R.id.progressBarselleractivity);
        loadbar.setVisibility(View.VISIBLE);


        Intent intent = getIntent();
        intentmessage = intent.getStringExtra("key");
        Toast.makeText(this, intentmessage, Toast.LENGTH_SHORT).show();
        if (intentmessage.equals("repair")) {
            myref.child("providers/ac").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    loadbar.setVisibility(View.INVISIBLE);
                    Log.d("datasnapshotrepair", String.valueOf(snapshot));
                    Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                    while (items.hasNext()) {
                        DataSnapshot item = items.next();
                        sellerphone.add(item.getKey().toString());
                        Toast.makeText(selleractivity.this, item.getKey(), Toast.LENGTH_SHORT).show();
                        String name = item.child("name").getValue().toString();
                        sellernames.add(name);
                        String price = item.child("repair").getValue().toString();
                        sellerprice.add(price);
                        String rating = item.child("rating").getValue().toString();
                        sellerrating.add(rating);
                    }
                    adapter();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
            if (intentmessage.equals("install")) {
                myref.child("providers/ac").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            Toast.makeText(selleractivity.this, item.getKey(), Toast.LENGTH_SHORT).show();
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("install").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if (intentmessage.equals("service")) {
                myref.child("providers/ac").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("service").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

            }
            if(intentmessage.equals("repairgeyser")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("service").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("installgeyser")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("service").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

            }
            if(intentmessage.equals("servicegeyser")){

            }
            if(intentmessage.equals("repariro")){
                myref.child("providers/ro").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("repair").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("installro")){
                myref.child("providers/ro").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("install").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("testro")){
                myref.child("providers/ro").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("test").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("servicero")){
                myref.child("providers/ro").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("service").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }

            if(intentmessage.equals("plumber")){
                myref.child("providers/plumber").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String price = item.child("visitcharge").getValue().toString();
                            sellerprice.add(price);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }

            if(intentmessage.equals("carpentar")){
                myref.child("providers/carpentar").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("painter")){
                myref.child("providers/painter").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("washinginstall")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("washingservice")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("washingrepair")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("painter")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("tv")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("microwave")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("wallmountchimney")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            if(intentmessage.equals("islandchimney")){
                myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadbar.setVisibility(View.INVISIBLE);
                        ArrayList<String> sellername = new ArrayList<>();
                        Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                        while (items.hasNext()) {
                            DataSnapshot item = items.next();
                            sellerphone.add(item.getKey().toString());
                            String name = item.child("name").getValue().toString();
                            sellernames.add(name);
                            String rating = item.child("rating").getValue().toString();
                            sellerrating.add(rating);
                        }
                        adapter();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }

        if(intentmessage.equals("electrician")){
            myref.child("providers/electrician").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    loadbar.setVisibility(View.INVISIBLE);
                    ArrayList<String> sellername = new ArrayList<>();
                    Iterator<DataSnapshot> items = snapshot.getChildren().iterator();
                    while (items.hasNext()) {
                        DataSnapshot item = items.next();
                        sellerphone.add(item.getKey().toString());
                        String name = item.child("name").getValue().toString();
                        sellernames.add(name);
                        String price = item.child("visitcharge").getValue().toString();
                        sellerprice.add(price);
                        String rating = item.child("rating").getValue().toString();
                        sellerrating.add(rating);
                    }
                    adapter();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });

        }
    }
    private void adapter(){
        RecyclerView recyclerView = findViewById(R.id.sellerrecyclerview);
        airconrepairadapter adapter = new airconrepairadapter(sellernames,sellerprice,sellerrating,sellerphone,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}