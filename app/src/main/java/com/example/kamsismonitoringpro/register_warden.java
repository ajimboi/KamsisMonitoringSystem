package com.example.kamsismonitoringpro;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register_warden extends AppCompatActivity {

    EditText FNR, INR, PNR, ER, PSR;
    Button RegisterBtn;
    private DatabaseReference usersReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_warden);

        FNR = findViewById(R.id.edtFullName);
        INR = findViewById(R.id.edtIdNum);
        PNR = findViewById(R.id.edtPhone);
        ER = findViewById(R.id.edtEmail);
        PSR = findViewById(R.id.edtPassword);
        RegisterBtn = findViewById(R.id.RegisterBtn);

        usersReference = FirebaseDatabase.getInstance().getReference("warden_users");

        RegisterBtn.setOnClickListener(view -> {
            String warden_name = FNR.getText().toString();
            String warden_idNumber = INR.getText().toString();
            String warden_phone = PNR.getText().toString();
            String warden_email = ER.getText().toString();
            String warden_password = PSR.getText().toString();

            if (TextUtils.isEmpty(warden_name) || TextUtils.isEmpty(warden_idNumber) || TextUtils.isEmpty(warden_phone) || TextUtils.isEmpty(warden_email) || TextUtils.isEmpty(warden_password)) {
                Toast.makeText(register_warden.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Create a user data object
                usersReference.child(warden_idNumber).setValue(new WardenHelperClass(warden_name, warden_idNumber, warden_phone, warden_email, warden_password));

                // Store user data in the database
                Toast.makeText(register_warden.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(register_warden.this, login_warden.class);
                startActivity(intent);
            }
        });
    }
}