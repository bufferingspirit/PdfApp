package com.example.admin.pdfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {

    SmsManager smsManager;
    EditText etMessage, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        smsManager = SmsManager.getDefault();
        etMessage = (EditText) findViewById(R.id.etMessage);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);

    }

    public void sendMessage(View view){
        smsManager.sendTextMessage(etPhoneNumber.getText().toString(), null, etMessage.getText().toString(), null, null);
        Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
    }
}
