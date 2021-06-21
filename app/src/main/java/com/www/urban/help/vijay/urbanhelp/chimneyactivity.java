package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class chimneyactivity extends AppCompatActivity {

    ImageButton wallmount,island;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chimneyactivity);

        wallmount =findViewById(R.id.wallmountchimney);
        island = findViewById(R.id.islandchimney);

        wallmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chimneyactivity.this,selleractivity.class);
                intent.putExtra("key","wallmountchimney");
                startActivity(intent);
            }
        });
        island.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chimneyactivity.this,selleractivity.class);
                intent.putExtra("key","islandchimney");
                startActivity(intent);
            }
        });
    }
}