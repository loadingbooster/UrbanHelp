package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class cleaningactivity extends AppCompatActivity {

    ImageButton cleanhome,cleanoffice,cleanshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaningactivity);

        cleanhome = findViewById(R.id.cleanhome);
        cleanoffice = findViewById(R.id.cleanoffice);
        cleanshop = findViewById(R.id.cleanshop);

        cleanhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cleaningactivity.this,cleaninghomeactivity.class);
                startActivity(intent);
            }
        });
        cleanoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cleaningactivity.this,officecleanactivity.class);
                startActivity(intent);
            }
        });
        cleanshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cleaningactivity.this,shopcleanactivity.class);
                startActivity(intent);
            }
        });

    }
}