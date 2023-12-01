package com.example.kamsismonitoringpro;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class login_warden extends AppCompatActivity {

    EditText INR, tvpass;
    TextView tvRegister, tvStudent, tvJPKK, tvWarden;
    Button LoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_warden);

        INR = findViewById(R.id.edtIdNum);
        tvpass = findViewById(R.id.edtPass);
        LoginBtn = findViewById(R.id.LoginBtn);
        tvRegister = findViewById(R.id.tvRegister);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateIdNumber() && validatePassword()) {
                    String idNumber = INR.getText().toString();
                    String password = tvpass.getText().toString();

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("warden_users");

                    databaseReference.orderByChild("warden_idNumber").equalTo(idNumber).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                boolean found = false;
                                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                    String passwordFromDB = userSnapshot.child("warden_password").getValue(String.class);
                                    if (passwordFromDB != null && passwordFromDB.equals(password)) {
                                        String wardenName = userSnapshot.child("warden_name").getValue(String.class);
                                        String wardenPhone = userSnapshot.child("warden_phone").getValue(String.class);
                                        String wardenIdnumber = userSnapshot.child("warden_idNumber").getValue(String.class);

                                        Intent intent = new Intent(login_warden.this, home_warden.class);
                                        intent.putExtra("warden_name", wardenName);
                                        intent.putExtra("warden_phone", wardenPhone);
                                        intent.putExtra("warden_idNumber", wardenIdnumber);
                                        startActivity(intent);
                                        finish();

                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    tvpass.setError("Invalid Credentials");
                                    tvpass.requestFocus();
                                }
                            } else {
                                INR.setError("User does not exist");
                                INR.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(login_warden.this, "Database Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_warden.this, register_warden.class);
                startActivity(intent);
            }
        });

        tvStudent = findViewById(R.id.tvStudent);
        tvStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_warden.this, Login.class);
                startActivity(intent);
            }
        });

        tvWarden = findViewById(R.id.tvWarden);
        tvWarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_warden.this, login_warden.class);
                startActivity(intent);
            }
        });
    }

    public Boolean validateIdNumber() {
        String val = INR.getText().toString();

        if (!val.matches(".*[a-zA-Z].*") || !val.matches(".*\\d.*")) {
            INR.setError("ID Number must contain both letters and numbers");
            return false;
        } else {
            INR.setError(null);
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