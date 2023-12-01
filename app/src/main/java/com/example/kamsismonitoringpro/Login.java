package com.example.kamsismonitoringpro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText tvMN, tvpass;
    TextView tvRegister,tvStudent,tvJPKK,tvWarden;
    Button LoginBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvMN = findViewById(R.id.edtIdNum);
        tvpass = findViewById(R.id.edtPass);
        LoginBtn = findViewById(R.id.LoginBtn);
        tvRegister = findViewById(R.id.tvRegister);

        sharedPreferences = getSharedPreferences("userSession", Context.MODE_PRIVATE);


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matrixNumber = tvMN.getText().toString();
                String password = tvpass.getText().toString();

                if (TextUtils.isEmpty(matrixNumber) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Matrix Number and Password are required", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

                    databaseReference.orderByChild("matrix").equalTo(matrixNumber).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                DataSnapshot userSnapshot = dataSnapshot.getChildren().iterator().next(); // Get the user data
                                String passwordFromDB = userSnapshot.child("password").getValue(String.class);
                                if (passwordFromDB != null && passwordFromDB.equals(password)) {
                                    // User authentication successful
                                    // Retrieve user information and pass it to the homepage
                                    String fullName = userSnapshot.child("name").getValue(String.class);
                                    String phoneNumber = userSnapshot.child("phone").getValue(String.class);
                                    String matrixnumber = userSnapshot.child("matrix").getValue(String.class);

                                    // Save matrix number in SharedPreferences for session management
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("matrixNumber", matrixnumber);
                                    editor.apply();

                                    Intent intent = new Intent(Login.this, Home.class);
                                    intent.putExtra("fullName", fullName);
                                    intent.putExtra("phoneNumber", phoneNumber);
                                    intent.putExtra("matrix", matrixnumber);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Passwords don't match
                                    tvpass.setError("Invalid Credentials");
                                    tvpass.requestFocus();
                                }
                            } else {
                                // User does not exist
                                tvMN.setError("User does not exist");
                                tvMN.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            // Handle database error, if any
                            Toast.makeText(Login.this, "Database Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



        tvRegister=(TextView) findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        tvStudent=(TextView) findViewById(R.id.tvStudent);
        tvStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Login.class);
                startActivity(intent);
            }
        });

        tvWarden=(TextView) findViewById(R.id.tvWarden);
        tvWarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, login_warden.class);
                startActivity(intent);
            }
        });
    }

    public Boolean validateMatrixNumber() {
        String val = tvMN.getText().toString();

        if (!val.matches(".*[a-zA-Z].*") || !val.matches(".*\\d.*")) {
            tvMN.setError("Matrix Number must contain both letters and numbers");
            return false;
        } else {
            tvMN.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = tvpass.getText().toString();
        if (val.isEmpty()) {
            tvpass.setError("Password cannot be empty");
            return false;
        } else {
            tvpass.setError(null);
            return true;
        }
    }
}
