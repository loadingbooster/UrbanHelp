package com.www.urban.help.vijay.urbanhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class driveractivity extends AppCompatActivity {

    CalendarView calenderView;
    Button oneday,month,week,continuebutton;
    String option,lastdate,currentmonth,currentdate,currentyear;
    int amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driveractivity);

        calenderView = findViewById(R.id.calendarViewdriver);
        oneday = findViewById(R.id.oneday);
        month = findViewById(R.id.month);
        week = findViewById(R.id.week);
        continuebutton = findViewById(R.id.continuedriver);

        SimpleDateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");
        Calendar currentCal = Calendar.getInstance();



        oneday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option = "ondeday";
                amount = 0;
                oneday.setBackgroundResource(R.drawable.buttoncurbe);
                oneday.setTextColor(Color.parseColor("#FFFFFF"));

                month.setBackgroundResource(R.drawable.buttondriver);
                month.setTextColor(Color.parseColor("#000000"));

                week.setBackgroundResource(R.drawable.buttondriver);
                week.setTextColor(Color.parseColor("#000000"));
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option = "month";
                amount = 30;
                month.setBackgroundResource(R.drawable.buttoncurbe);
                month.setTextColor(Color.parseColor("#FFFFFF"));

                oneday.setBackgroundResource(R.drawable.buttondriver);
                oneday.setTextColor(Color.parseColor("#000000"));

                week.setBackgroundResource(R.drawable.buttondriver);
                week.setTextColor(Color.parseColor("#000000"));

            }
        });
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option = "week";
                amount   = 6;
                week.setBackgroundResource(R.drawable.buttoncurbe);
                week.setTextColor(Color.parseColor("#FFFFFF"));

                month.setBackgroundResource(R.drawable.buttondriver);
                month.setTextColor(Color.parseColor("#000000"));

                oneday.setBackgroundResource(R.drawable.buttondriver);
                oneday.setTextColor(Color.parseColor("#000000"));

            }
        });
        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                SimpleDateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");
                Calendar currentCal = Calendar.getInstance();
                Calendar nextcal = Calendar.getInstance();
                currentCal.set(Calendar.MONTH,month);
                currentCal.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                currentCal.set(Calendar.YEAR,year);
                currentCal.add(Calendar.DATE,amount);
                String toDate=dateFormat.format(currentCal.getTime());
                Toast.makeText(driveractivity.this, toDate, Toast.LENGTH_SHORT).show();
            }
        });

        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}