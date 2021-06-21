package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class washingmachineactivity extends AppCompatActivity {

    ImageButton install,service,repair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washingmachineactivity);

        install = findViewById(R.id.washinginstall);
        service = findViewById(R.id.washingservice);
        repair = findViewById(R.id.washingrepair);

        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(washingmachineactivity.this,selleractivity.class);
                intent.putExtra("key","washinginstall");
                startActivity(intent);
            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(washingmachineactivity.this,selleractivity.class);
                intent.putExtra("key","washingservice");
                startActivity(intent);
            }
        });
        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(washingmachineactivity.this,selleractivity.class);
                intent.putExtra("key","washingrepair");
                startActivity(intent);
            }
        });

    }
}