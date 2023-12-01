package com.example.kamsismonitoringpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WardenHomeFragment extends Fragment {
    private TextView userInfoTextView; // Declare userInfoTextView here
    private DatabaseReference usersReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warden_home, container, false);

        userInfoTextView = view.findViewById(R.id.userInfo); // Initialize userInfoTextView here

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            String wardenname = extras.getString("warden_name");
            String wardenNumber = extras.getString("warden_phone");
            String wardenidNumber = extras.getString("warden_idNumber");

            if (wardenname != null && wardenNumber != null) {
                // Display the user information
                String userInfo = "Warden Name: " + wardenname + "\n\n"
                        + "Warden Phone: " + wardenNumber + "\n\n"
                        + "Warden ID: " + wardenidNumber + "\n\n";

                userInfoTextView.setText(userInfo);
            }
        }

        return view;
    }
}