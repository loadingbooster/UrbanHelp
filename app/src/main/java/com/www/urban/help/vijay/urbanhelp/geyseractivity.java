package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class geyseractivity extends AppCompatActivity {

    ImageButton repair,install,service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geyseractivity);

        repair = findViewById(R.id.repairgeyser);
        install = findViewById(R.id.installgeyser);
        service = findViewById(R.id.servicegeyser);


        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), selleractivity.class);
                intent1.putExtra("key","repairgeyser");
                startActivity(intent1);
            }
        });

        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), selleractivity.class);
                intent1.putExtra("key","installgeyser");
                startActivity(intent1);
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), selleractivity.class);
                intent1.putExtra("key","servicegeyser");
                startActivity(intent1);
            }
        });
    }
}