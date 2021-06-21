package com.www.urban.help.vijay.urbanhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class otpactivity extends AppCompatActivity {

    Button verifyotp,resendotp;
    EditText otpfield;
    TextView otpcountdown,disphone;
    String mVerificationId;
    private FirebaseAuth mAuth;
    String phonenumber;
    String intention;
    PhoneAuthProvider.ForceResendingToken mResendToken;
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);
        mAuth = FirebaseAuth.getInstance();

        otpfield = findViewById(R.id.otpfield);
        otpcountdown = findViewById(R.id.otpcountdown);
        resendotp = findViewById(R.id.resendotp);
        resendotp.setVisibility(View.INVISIBLE);
        verifyotp = findViewById(R.id.verifyotp);
        verifyotp.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        disphone = findViewById(R.id.phoneotp);

        phonenumber = intent.getStringExtra("phone");
        intention = intent.getStringExtra("intention");
        otpverification();

        disphone.setText("+91"+phonenumber);
        verifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otpfield.getText().toString());
                signInWithPhoneAuthCredential(credential);
            }
        });

        otpfield.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(otpfield.getText().toString().length() == 6){
                    verifyotp.setVisibility(View.VISIBLE);
                }
                else{
                    verifyotp.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                otpcountdown.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                resendotp.setVisibility(View.VISIBLE);
                otpcountdown.setVisibility(View.INVISIBLE);
            }
        }.start();


        resendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resendotp.setVisibility(View.INVISIBLE);
                otpcountdown.setVisibility(View.VISIBLE);
                otpverification();
                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        otpcountdown.setText(String.valueOf(millisUntilFinished / 1000));
                    }

                    public void onFinish() {
                        resendotp.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });





    }

    public void otpverification(){
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+phonenumber)       // Phone number to verify
                        .setTimeout(30L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                Toast.makeText(otpactivity.this, "verification complete", Toast.LENGTH_SHORT).show();
                                if(intention.equals("signup")){
                                    signuser(phonenumber);
                                }
                                if(intention.equals("login")){
                                    loguser(phonenumber);
                                }
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(otpactivity.this, "Please Check Phone Number", Toast.LENGTH_LONG).show();
                            //    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otpfield.getText().toString());
                             //   signInWithPhoneAuthCredential(credential);

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {

                                // The SMS verification code has been sent to the provided phone number, we
                                // now need to ask the user to enter the code and then construct a credential
                                // by combining the code with a verification ID.

                                // Save verification ID and resending token so we can use them later
                                mVerificationId = verificationId;
                                mResendToken = token;


                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            if(intention.equals("signup")){
                                signuser(phonenumber);
                            }
                            if(intention.equals("login")){
                                loguser(phonenumber);
                            }
                            // Update UI
                        } else {
                            Toast.makeText(otpactivity.this, "Please check the enterd OTP", Toast.LENGTH_LONG).show();
                            // Sign in failed, display a message and update the UI

                        }
                    }
                });
    }

    private void signuser(String phonenumber){
        try {
            DatabaseReference myref = database.getReference("customers");
            myref.child(phonenumber).child("user").setValue("1");
            FileOutputStream fos;
            String filename = "userphone";
            String data = phonenumber;
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
            //default mode is PRIVATE, can be APPEND etc.
            fos.write(data.getBytes());
            fos.close();
            FirebaseUser user = mAuth.getCurrentUser();
         //   updateUI(user);
            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),homescreen.class);
            startActivity(intent);
            finish();
        } catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();
        }

    }
    private void loguser(String phonenumber){
        try {
            FileOutputStream fos;
            String filename = "userphone";
            String data = phonenumber;
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
            //default mode is PRIVATE, can be APPEND etc.
            fos.write(data.getBytes());
            fos.close();
            Toast.makeText(this, "User Logged In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),homescreen.class);
            startActivity(intent);
            finish();
        } catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();
        }
    }

}