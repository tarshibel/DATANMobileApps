package com.example.datanmobileapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_SendSMSPage extends AppCompatActivity {
    Button btnSend;
    Button btnClear;
    EditText txtPhoneNumber;
    EditText txtMessage;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smspage);

        btnSend = (Button) findViewById(R.id.btnSend);
        btnClear = findViewById(R.id.btnClearSMS);
        txtPhoneNumber = (EditText) findViewById(R.id.txtPhoneNumber);
        txtMessage = (EditText) findViewById(R.id.txtMessage);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPhoneNumber.setText("");
                txtMessage.setText("");
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNo = txtPhoneNumber.getText().toString();
                message = txtMessage.getText().toString();

                Intent sms = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNo, null));
                sms.putExtra("sms_body", message);
                startActivity(sms);

                Toast.makeText(Activity_SendSMSPage.this, "SMS Sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}