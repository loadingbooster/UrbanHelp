package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class homescreen extends AppCompatActivity{
    ImageButton electrician,plumber,carpenter,men,women,appliance,driver,carrent,truckrent,roservice,yoga,acrepair,pest,painter,cleaning,vehiclerepair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        electrician = findViewById(R.id.electrician);
        plumber = findViewById(R.id.plumber);
        carpenter = findViewById(R.id.carpenter);
        men = findViewById(R.id.men);
        women  = findViewById(R.id.women);
        appliance = findViewById(R.id.appliance);
        driver = findViewById(R.id.driver);
        carrent = findViewById(R.id.carrent);
        truckrent = findViewById(R.id.truckrent);
        roservice = findViewById(R.id.waterpurifier);
        yoga = findViewById(R.id.yoga);
        acrepair = findViewById(R.id.aircon);
        pest = findViewById(R.id.pestcontrol);
        painter = findViewById(R.id.painter);
        cleaning = findViewById(R.id.cleaning);
        vehiclerepair = findViewById(R.id.vehiclerepair);





        cleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this,cleaningactivity.class);
                startActivity(intent);
            }
        });
        appliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), applianceactivity.class);
                startActivity(intent);
            }
        });

        acrepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), airconactivity.class);
                startActivity(intent1);
            }
        });
        roservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), waterpurifieractivity.class);
                startActivity(intent2);
            }
        });
        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this,driveractivity.class);
                startActivity(intent);
            }
        });
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this,selleractivity.class);
                intent.putExtra("key","plumber");
                startActivity(intent);
            }
        });
        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this,selleractivity.class);
                intent.putExtra("key","carpentar");
                startActivity(intent);
            }
        });
        painter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this,selleractivity.class);
                intent.putExtra("key","painter");
                startActivity(intent);
            }
        });
        vehiclerepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, repairactivity.class);
                startActivity(intent);
            }
        });
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescreen.this, selleractivity.class);
                intent.putExtra("key","electrician");
                startActivity(intent);
            }
        });

    }

}