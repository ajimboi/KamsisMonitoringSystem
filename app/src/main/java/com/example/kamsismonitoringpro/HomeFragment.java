package com.example.kamsismonitoringpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private TextView userInfoTextView; // Declare userInfoTextView here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        userInfoTextView = view.findViewById(R.id.userInfo); // Initialize userInfoTextView here

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            String fullName = extras.getString("fullName");
            String phoneNumber = extras.getString("phoneNumber");
            String matrixNumber = extras.getString("matrix");

            if (fullName != null && phoneNumber != null) {
                // Display the user information
                String userInfo = "Full Name: " + fullName + "\n\n"
                        + "Phone Number: " + phoneNumber + "\n\n"
                        + "Matrix Number: " + matrixNumber + "\n\n";

                userInfoTextView.setText(userInfo);
            }
        }

        return view;
    }
}
