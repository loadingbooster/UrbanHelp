package com.www.urban.help.vijay.urbanhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class cleaninghomeactivity extends AppCompatActivity {


    Button twice,one,mop,dish,cook,book;

    int cooking;
    int mopping;
    int dishing;
    CalendarView calenderhomeclean;

    Chip chipcooking,chipdish,chipmopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaninghomeactivity);

        twice = findViewById(R.id.twicedaily);
        one = findViewById(R.id.oncedaily);
        book = findViewById(R.id.bookcleaning);
        chipcooking = findViewById(R.id.chipcooking);
        chipdish = findViewById(R.id.chipdishwashing);
        chipmopping = findViewById(R.id.chipmopping);
        calenderhomeclean = findViewById(R.id.calendarViewcleaning);


        twice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twice.setBackgroundResource(R.drawable.buttoncurbe);
                twice.setTextColor(Color.parseColor("#FFFFFF"));

                one.setBackgroundResource(R.drawable.buttondriver);
                one.setTextColor(Color.parseColor("#000000"));
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setBackgroundResource(R.drawable.buttoncurbe);
                one.setTextColor(Color.parseColor("#FFFFFF"));

                twice.setBackgroundResource(R.drawable.buttondriver);
                twice.setTextColor(Color.parseColor("#000000"));
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        chipcooking.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chipcooking.isChecked()){
                    cooking = 1;
                }
                else{
                    cooking = 0;
                }
            }
        });
        chipmopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chipmopping.isChecked()){
                    mopping=1;
                }
                else{
                    mopping=0;
                }
            }
        });
        chipdish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chipdish.isChecked()){
                    dishing=1;
                }else {
                    dishing=0;
                }
            }
        });

        calenderhomeclean.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");
                Calendar currentCal = Calendar.getInstance();
                Calendar nextcal = Calendar.getInstance();
                currentCal.set(Calendar.MONTH,month);
                currentCal.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                currentCal.set(Calendar.YEAR,year);
                currentCal.add(Calendar.DATE,30);
                String toDate=dateFormat.format(currentCal.getTime());
                Toast.makeText(cleaninghomeactivity.this, toDate, Toast.LENGTH_SHORT).show();
            }
        });

    }
}