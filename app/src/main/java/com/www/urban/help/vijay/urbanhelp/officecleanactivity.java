
package com.www.urban.help.vijay.urbanhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class officecleanactivity extends AppCompatActivity {

    CalendarView officecleancalendar;
    Button bookofficeclean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officecleanactivity);

        officecleancalendar = findViewById(R.id.calendarViewofficeclean);
        bookofficeclean = findViewById(R.id.bookofficeclean);

        officecleancalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
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
                Toast.makeText(officecleanactivity.this, toDate, Toast.LENGTH_SHORT).show();
            }
        });
    }
}