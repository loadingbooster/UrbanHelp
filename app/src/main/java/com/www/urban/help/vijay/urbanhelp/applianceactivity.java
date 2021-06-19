package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class applianceactivity extends AppCompatActivity {

    ImageButton aircon,geyser,tv,ro,washingmachine,microwave,chimney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applianceactivity);

        aircon = findViewById(R.id.appac);
        geyser = findViewById(R.id.appgeyser);
        tv = findViewById(R.id.apptv);
        ro = findViewById(R.id.appro);
        washingmachine = findViewById(R.id.appwashingmachine);
        microwave = findViewById(R.id.appmicrowave);
        chimney = findViewById(R.id.appchimney);

        aircon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(applianceactivity.this, airconactivity.class);
                startActivity(intent);
            }
        });

        geyser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(applianceactivity.this,geyseractivity.class);
                startActivity(intent);
            }
        });

        ro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(applianceactivity.this,waterpurifieractivity.class);
                startActivity(intent);
            }
        });

        chimney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(applianceactivity.this, chimneyactivity.class);
                startActivity(intent);
            }
        });

        washingmachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(applianceactivity.this,washingmachineactivity.class);
                startActivity(intent);
            }
        });

    }
}