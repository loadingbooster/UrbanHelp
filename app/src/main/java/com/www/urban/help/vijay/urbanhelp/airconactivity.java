package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class airconactivity extends AppCompatActivity {

    ImageButton airconrepairbutton;
    ImageButton airconinstallbutton;
    ImageButton airconservicebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airconactivity);

        airconrepairbutton = findViewById(R.id.airconactivityrepairbutton);
        airconinstallbutton = findViewById(R.id.airconactivityinstallbutton);
        airconservicebutton = findViewById(R.id.airconactivityservicebutton);

        airconrepairbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), selleractivity.class);
                intent1.putExtra("key","repair");
                startActivity(intent1);
            }
        });

        airconinstallbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), selleractivity.class);
                intent2.putExtra("key","install");
                startActivity(intent2);
            }
        });

        airconservicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(),selleractivity.class);
                intent3.putExtra("key","service");
                startActivity(intent3);
            }
        });
    }
}