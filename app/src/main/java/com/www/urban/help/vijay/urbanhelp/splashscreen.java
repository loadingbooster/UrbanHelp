package com.www.urban.help.vijay.urbanhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.io.File;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(fileExist("userphone")){
                    Intent openhome = new Intent(splashscreen.this, homescreen.class);
                    startActivity(openhome);
                }else{
                    Intent openuseract = new Intent(splashscreen.this, loginactivity.class);
                    startActivity(openuseract);
                }
               finish();
            }
        },2000);
    }

    private boolean fileExist(String userphone) {
        File file = getBaseContext().getFileStreamPath(userphone);
        return file.exists();
    }
}