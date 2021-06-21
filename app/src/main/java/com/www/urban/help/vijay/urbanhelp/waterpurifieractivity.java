package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class waterpurifieractivity extends AppCompatActivity {

    ImageButton repair,install,test,service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterpurifieractivity);

        repair = findViewById(R.id.repairro);
        install = findViewById(R.id.installro);
        test = findViewById(R.id.tesro);
        service = findViewById(R.id.servicero);

        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(waterpurifieractivity.this,selleractivity.class);
                intent.putExtra("key","repariro");
                startActivity(intent);

            }
        });
        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(waterpurifieractivity.this,selleractivity.class);
                intent.putExtra("key","installro");
                startActivity(intent);

            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(waterpurifieractivity.this,selleractivity.class);
                intent.putExtra("key","testro");
                startActivity(intent);

            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(waterpurifieractivity.this,selleractivity.class);
                intent.putExtra("key","servicero");
                startActivity(intent);

            }
        });
    }
}