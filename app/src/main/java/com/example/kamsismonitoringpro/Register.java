package com.example.kamsismonitoringpro;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText FNR, MNR, PNR, PSR, ER; // Your EditText variables

    private Button registerButton;
    private DatabaseReference usersReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FNR = findViewById(R.id.edtFullName);
        MNR = findViewById(R.id.edtIdNum);
        PNR = findViewById(R.id.edtPhone);
        PSR = findViewById(R.id.edtPassword);
        ER = findViewById(R.id.edtEmail);

        registerButton = findViewById(R.id.RegisterBtn);

        usersReference = FirebaseDatabase.getInstance().getReference("users");

        registerButton.setOnClickListener(view -> {
            String name = FNR.getText().toString();
            String matrix = MNR.getText().toString();
            String phone = PNR.getText().toString();
            String email = ER.getText().toString();
            String password = PSR.getText().toString();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(matrix) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(Register.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Use the matrix number as the key for storing user data
                usersReference.child(matrix).setValue(new HelperClass(name, matrix, phone, email, password));

                Toast.makeText(Register.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
